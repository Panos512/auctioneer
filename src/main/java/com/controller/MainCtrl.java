package com.controller;


import com.dao.CategoryRepository;
import com.dao.ItemRepository;
import com.dao.PhotosRepository;
import com.dao.UserRepository;

import com.dto.*;


import com.entity.*;
import com.exceptions.BadRequestException;
import com.mappers.PhotoMapper;
import com.mappers.UserMapper;
import com.mappers.ItemMapper;
import com.user.UserAuthorizer;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.UUID;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Component
@RestController
public class MainCtrl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PhotosRepository photosRepository;

    @Autowired
    private UserAuthorizer userAuthorizer;

    //@Autowired
    //private ItemCategoryRepository itemCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private UserDto convertToUsersDTO(Users user) {

        return UserMapper.registerUsersToUser(user);
    }

    private List<UserDto> convertToUsersDTOs(List<Users> users) {
        return users.stream()
                .map(this::convertToUsersDTO)
                .collect(toList());
    }

    private ItemDto convertToItemDTO(Item item) {
        return ItemMapper.registerItemToItem(item);
    }

    private List<ItemDto> convertToItemDTOs(List<Item> items) {
        return items.stream()
                .map(this::convertToItemDTO)
                .collect(toList());
    }

    private PhotoDto convertToPhotoDTO(Photos photo) {
        return PhotoMapper.registerPhotosToPhotoDto(photo);
    }

    private List<PhotoDto> convertToPhotoDTOs(List<Photos> photos) {
        return photos.stream()
                .map(this::convertToPhotoDTO)
                .collect(toList());
    }

    @RequestMapping(path = "/get_user_list", method = RequestMethod.GET, produces = "application/json")
    public List<UserDto> get_users_list() throws Exception {
        // TODO: Need to authenticate with token if the user is admin!!!!!
        List<Users> users = userRepository.findAll();
        return convertToUsersDTOs(users);
    }

    @RequestMapping(path = "/approve_user", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void approve_user(@RequestBody VerifyRequestDto verifyRequestDto) throws Exception {
        Users user = userRepository.findUserByUserId(verifyRequestDto.getUserId());

        user.setVerified(Boolean.TRUE);
        userRepository.save(user);
    }

    @RequestMapping(path = "/get_user/{userId}", method = RequestMethod.GET, produces = "application/json")
    public UserDto get_user(@PathVariable int userId) throws Exception {
        Users user = userRepository.findUserByUserId(userId);

        return UserMapper.registerUsersToUser(user);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ExceptionHandler({BadRequestException.class})
    public UserLogInResponseDto login(@RequestBody UserLoginRequestDto userLogInRequestDto) throws Exception {
        //search for user
        Users user = userRepository.findUserByUsernameAndPassword(userLogInRequestDto.getUsername(), userLogInRequestDto.getPassword());
        if (user == null)
            throw new BadRequestException("User not found");
        //generate session token
        UUID generatedToken = UUID.randomUUID();

        //prepare response
        UserLogInResponseDto userLogInResponseDto = new UserLogInResponseDto();
        userLogInResponseDto.setUserId((long) user.getUserId());
        userLogInResponseDto.setRole((String) user.getRole());
        userLogInResponseDto.setGeneratedToken(generatedToken);


        //put session token to hashmap
        userAuthorizer.setUserSession(generatedToken, (long) user.getUserId());
        return userLogInResponseDto;
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public UserSignUpResponseDto register(@RequestBody UserSignUpRequestDto userSignUpRequestDto) throws Exception {

        Users user = userRepository.findUserByUsernameAndPassword(userSignUpRequestDto.getUsername(), userSignUpRequestDto.getPassword());

        if (user != null) {
        } // TODO: Throw exception if user exists, to inform angular.

        // Create User
        Users new_user = UserMapper.registerRequestToUser(userSignUpRequestDto);
        userRepository.save(new_user);

        // Create dummy response
        long i = 1;
        UserSignUpResponseDto userSignUpResponseDto = new UserSignUpResponseDto();
        userSignUpResponseDto.setUserId(i);

        return userSignUpResponseDto; // TODO: Return something meaningful.

    }


    // ITEMS
    // TODO: MOVE TO NEW FILE
    @RequestMapping(path = "/add_auction", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ItemAddResponseDto register(@RequestBody ItemAddRequestDto itemAddRequestDto) throws Exception {

        System.out.println(itemAddRequestDto);

        Item new_item = ItemMapper.registerRequestToItem(itemAddRequestDto);


        itemRepository.save(new_item);
        itemRepository.flush();

        List<String> photos = itemAddRequestDto.getPhotos();
        Integer itemId = new_item.getItemId();


        photos.forEach(photo -> {
            Photos photosEntity = new Photos();

            photosEntity.setItemByItemid(new_item);
            System.out.println(itemId);
            photosEntity.setPhotoPath(photo);

            System.out.println(photo);

            photosRepository.save(photosEntity);
            photosRepository.flush();
            System.out.println(photosEntity);
        });



        // Create dummy response
        ItemAddResponseDto itemAddResponseDto = new ItemAddResponseDto();
        itemAddResponseDto.setItemId(new_item.getItemId());

        return itemAddResponseDto; // TODO: Return something meaningful.

    }

    @RequestMapping(path = "/auctions_list", method = RequestMethod.GET, produces = "application/json")
    public List<ItemDto> auctions_list() throws Exception {
        List<Item> items = itemRepository.findByStartDateIsNotNull();
        return convertToItemDTOs(items);
    }

    @RequestMapping(path="/get_auction/{itemId}", method = RequestMethod.GET, produces = "application/json")
    public ItemDto get_auction(@PathVariable int itemId) throws Exception {
        Item item = itemRepository.findItemByItemId(itemId);

        return ItemMapper.registerItemToItem(item);
    }

    @RequestMapping(value = "/upload_image", method = RequestMethod.POST)
    public UploadFileResponseDto UploadFile(MultipartHttpServletRequest request) throws IOException {




        Iterator<String> itr = request.getFileNames();
        MultipartFile file = request.getFile(itr.next());
        String fileName = file.getOriginalFilename();

        File dir = new File("./src/main/resources/static/images/user_uploads");

        if (dir.isDirectory()) {

            File serverFile = new File(dir, fileName);

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(file.getBytes());
            stream.close();

            String path = "images/user_uploads/" + fileName;
            System.out.println(path);
            UploadFileResponseDto uploadFileResponseDto = new UploadFileResponseDto();
            uploadFileResponseDto.setPath(path);

            return uploadFileResponseDto;
        } else {
            return null;
        }

    }

    @ExceptionHandler(Exception.class)
    public void notFound(HttpServletResponse e) throws Exception {
        e.sendError(HttpStatus.NOT_FOUND.value());
    }

}
