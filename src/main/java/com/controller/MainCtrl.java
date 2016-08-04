package com.controller;


import com.dao.ItemRepository;
import com.dao.UserRepository;
import com.dto.*;


import com.entity.Item;
import com.entity.Users;
import com.exceptions.BadRequestException;
import com.mappers.UserMapper;
import com.mappers.ItemMapper;
import com.user.UserAuthorizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
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
    private UserAuthorizer userAuthorizer;


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
        System.out.println("w");
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
        // Create Item
//        Item item = UserMapper.registerRequestToUser(userSignUpRequestDto);
        Item new_item = ItemMapper.registerRequestToItem(itemAddRequestDto);
//        userRepository.save(new_user);
        System.out.println(new_item);
        itemRepository.save(new_item);
        System.out.println(new_item);
        // Create dummy response
        long i = 1;
        ItemAddResponseDto itemAddResponseDto = new ItemAddResponseDto();
        itemAddResponseDto.setItemId(i);

        return itemAddResponseDto; // TODO: Return something meaningful.

    }

    @RequestMapping(path = "/auctions_list", method = RequestMethod.GET, produces = "application/json")
    public List<ItemDto> auctions_list() throws Exception {

        List<Item> items = itemRepository.findByStartDateIsNotNull();
        // TODO: We need to add the list of categories associated with every item somehow somewhere. Maybe even in a previeous step (fetch it automaticaly using a `find` function)

        return convertToItemDTOs(items);
    }


//    @RequestMapping(path="/get_auction/{itemId}", method = RequestMethod.GET, produces = "application/json")
//    public UserDto get_user(@PathVariable int userId) throws Exception {
//        Users user = userRepository.findUserByUserId(userId);
//
//        return UserMapper.registerUsersToUser(user);
//    }


//    @RequestMapping(path="/upload_image", method = RequestMethod.POST, consumes = "multipart/*")
//    public void UploadFile(MultipartFile file) throws Exception {
//        System.out.println("I AM IN");
//        System.out.println(file);
//        Document document = new Document(file.getBytes(), file.getOriginalFilename() );
//        System.out.println(document);
////        getArchiveService().save(document);
////        return document.getMetadata();
//    } catch (Exception e) {
//        System.out.println("error");
//    }
//    }

    @RequestMapping(value = "/upload_image", method = RequestMethod.POST)
    public void UploadFile(MultipartHttpServletRequest request) throws IOException {
        System.out.println(request);
        Iterator<String> itr = request.getFileNames();
        System.out.println("tsa");
        System.out.println(itr);
        MultipartFile file = request.getFile(itr.next());
        System.out.println("sout");
        System.out.println(file);
        String fileName = file.getOriginalFilename();
        File dir = new File("./src/main/resources/static/images");
        String absolutePath = dir.getAbsolutePath();
        System.out.println(absolutePath);
        if (dir.isDirectory()) {
            File serverFile = new File(dir, fileName);
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(file.getBytes());
            stream.close();
        } else {
            System.out.println("not");
        }

    }



//    @RequestMapping(value = "/upload_image", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity<?> uploadFile(MultipartFile uploadfile) {
//
//        try {
//            // Get the filename and build the local file path (be sure that the
//            // application have write permissions on such directory)
//            String filename = uploadfile.getOriginalFilename();
//            String directory = "/var/netgloo_blog/uploads";
//            String filepath = Paths.get(directory, filename).toString();
//
//            // Save the file locally
//            BufferedOutputStream stream =
//                    new BufferedOutputStream(new FileOutputStream(new File(filepath)));
//            stream.write(uploadfile.getBytes());
//            stream.close();
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    } // method uploadFile



    @ExceptionHandler(Exception.class)
    public void notFound(HttpServletResponse e) throws Exception {
        e.sendError(HttpStatus.NOT_FOUND.value());
    }

}
