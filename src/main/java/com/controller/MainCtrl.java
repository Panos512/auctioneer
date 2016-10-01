package com.controller;


import com.dao.*;

import com.dto.*;


import com.entity.*;
import com.exceptions.BadRequestException;
import com.mappers.BidMapper;
import com.mappers.PhotoMapper;
import com.mappers.UserMapper;
import com.oxMappers.ItemJax;
import com.oxMappers.ItemsJax;
import com.mappers.ItemMapper;
import com.mappers.MessageMapper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.user.UserAuthorizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.stream.Collectors;
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

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Autowired
    private MessageRepository messageRepository;


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

    private MessageDto convertToMessageDTO(Message msg) {
        return MessageMapper.convertMessageEntityToDto(msg);
    }




    private List<MessageDto> convertToMessageDTOs(List<Message> items) {
        return items.stream()
                .map(this::convertToMessageDTO)
                .collect(toList());
    }

    private BidDto convertToBidsDTO(Bids bid) {

        return BidMapper.registerBidToDto(bid);
    }

    private List<BidDto> convertToBidsDTOs(List<Bids> bids) {
        return bids.stream()
                .map(this::convertToBidsDTO)
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


   private void  isUserAdmin(String token) throws BadRequestException{
        UUID ltoken=UUID.fromString(token);
        Integer userId =userAuthorizer.getUserId(ltoken);
        Users user= userRepository.findUserByUserId(userId);
        if (!user.getRole().equals("admin"))
            throw new BadRequestException("User is not admin");

    }

    private Users get_user_info(String token) throws BadRequestException{
        UUID ltoken=UUID.fromString(token);
        Integer userId =userAuthorizer.getUserId(ltoken);
        Users user= userRepository.findUserByUserId(userId);
        if (user == null)
            throw new BadRequestException("User not found");
        return user;

    }

    @RequestMapping(path = "/get_user_list", method = RequestMethod.GET, produces = "application/json")
    public List<UserDto> get_users_list(@RequestHeader(value="token")String token) throws Exception {
    	isUserAdmin(token);
        List<Users> users = userRepository.findAll();
        return convertToUsersDTOs(users);

    }


    @RequestMapping(path = "/get_my_auctions", method = RequestMethod.GET, produces = "application/json")
    public List<AuctionBidsDto> get_my_auctions(@RequestHeader(value="token")String token) throws Exception {
        Users user = get_user_info(token);
        List<Item> items = user.getItems();

        List<AuctionBidsDto> my_bids = new ArrayList();
        items.forEach(item -> {
            AuctionBidsDto auctionBidsDto = new AuctionBidsDto();
            auctionBidsDto.setItemId(item.getItemId());
            auctionBidsDto.setItemName(item.getName());
            auctionBidsDto.setStartDate(item.getStartDate());
            auctionBidsDto.setEndDate(item.getEndDate());
            auctionBidsDto.setBids((List)item.getBids());

            my_bids.add(auctionBidsDto);
        });


        return my_bids;

    }



    @RequestMapping(path = "/get_categories", method = RequestMethod.GET, produces = "application/json")
    public List<Category> get_categories(@RequestHeader(value="token")String token) throws Exception {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @RequestMapping(path = "/approve_user", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void approve_user(@RequestBody VerifyRequestDto verifyRequestDto,@RequestHeader(value="token")String token) throws Exception {
    	isUserAdmin(token);
    	Users user = userRepository.findUserByUserId(verifyRequestDto.getUserId());

        user.setVerified(Boolean.TRUE);
        userRepository.save(user);
    }

    @RequestMapping(path = "/get_user/{userId}", method = RequestMethod.GET, produces = "application/json")
    public UserDto get_user(@PathVariable int userId,@RequestHeader(value="token")String token) throws Exception {
    	isUserAdmin(token);
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
        userAuthorizer.setUserSession(generatedToken, user.getUserId());
        return userLogInResponseDto;
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void logout(@RequestHeader(value="token")String token){
    	userAuthorizer.removeUserSession(UUID.fromString(token));
    	System.out.println("fdf");

    }

    @RequestMapping(path = "/vote_up/{userId}", method = RequestMethod.POST)
    public void vote_up(@RequestHeader(value="token")String token, @PathVariable int userId){

        Users user = userRepository.findUserByUserId(userId);

        user.setSellerRating(user.getSellerRating() + 1);

        userRepository.save(user);

        userRepository.flush();


    }

    @RequestMapping(path = "/vote_down/{userId}", method = RequestMethod.POST)
    public void vote_down(@RequestHeader(value="token")String token, @PathVariable int userId){

        Users user = userRepository.findUserByUserId(userId);

        user.setSellerRating(user.getSellerRating() - 1);

        userRepository.save(user);

        userRepository.flush();


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

        Item new_item = ItemMapper.registerRequestToItem(itemAddRequestDto);
        new_item.setUser(userRepository.findUserByUserId(itemAddRequestDto.getSellerId()));
        itemRepository.save(new_item);
        itemRepository.flush();
        Integer itemId = new_item.getItemId();
        if (itemAddRequestDto.getPhotos() != null) {
            List<String> photos = itemAddRequestDto.getPhotos();


            photos.forEach(photo -> {
                Photos photosEntity = new Photos();

                photosEntity.setItemByItemid(new_item);
                photosEntity.setPhotoPath(photo);


                photosRepository.save(photosEntity);
                photosRepository.flush();
                System.out.println(photosEntity);
            });
        };


        List<CategoryDto> categories = itemAddRequestDto.getCategories();

        categories.forEach(category -> {
            ItemCategory categoryEntity = new ItemCategory();

            // FIXME: This is really not good. Should be done with jpa.
            categoryEntity.setCategoryId(category.getId());
            categoryEntity.setItemId(itemId);

            itemCategoryRepository.save(categoryEntity);
            itemCategoryRepository.flush();
            System.out.println(categoryEntity);
        });



        // Create dummy response
        ItemAddResponseDto itemAddResponseDto = new ItemAddResponseDto();
        itemAddResponseDto.setItemId(new_item.getItemId());

        return itemAddResponseDto; // TODO: Return something meaningful.

    }

    @RequestMapping(path = "/auctions_list", method = RequestMethod.GET, produces = "application/json")
    public List<ItemDto> auctions_list() throws Exception {
        List<Item> items = itemRepository.findActiveItems();
        return convertToItemDTOs(items);
    }

    @RequestMapping(path = "/auctions_list_category/{categoryId}", method = RequestMethod.GET, produces = "application/json")
    public List<ItemDto> auctions_list_category(@PathVariable int categoryId) throws Exception {
        List<Item> items=itemRepository.findActiveItemsByCategoryId(categoryId);
        return convertToItemDTOs(items);
    }





    @RequestMapping(path="/get_auction/{itemId}", method = RequestMethod.GET, produces = "application/json")
    public ItemDto get_auction(@PathVariable int itemId) throws Exception {
        Item item = itemRepository.findItemByItemId(itemId);

        return ItemMapper.registerItemToItem(item);
    }


    @RequestMapping(path = "/send_message", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void sentMessage(@RequestBody MessageDto pMessage) throws Exception {
        Message newMessage=MessageMapper.convertMessageDtoToEnitry(pMessage);
        messageRepository.save(newMessage);
        messageRepository.flush();
    }

    @RequestMapping(path = "/delete_message", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void delete_message(@RequestBody MessageDto pMessage) throws Exception {
        Message message = MessageMapper.convertMessageDtoToEnitry(pMessage);

        messageRepository.delete(message);
        messageRepository.flush();
    }


    @RequestMapping(path = "/inbox/{idReceiver}", method = RequestMethod.GET,  produces = "application/json")
    public List<MessageDto> inbox(@PathVariable int idReceiver	) throws Exception {

    	List<Message> inboxList = messageRepository.getInboxMessages(idReceiver);
    	return convertToMessageDTOs(inboxList);
      }

    @RequestMapping(path = "/outbox/{idSender}", method = RequestMethod.GET,  produces = "application/json")
    public List<MessageDto> outbox(@PathVariable int idSender	) throws Exception {

        List<Message> outboxList = messageRepository.getOutboxMessages(idSender);
        return convertToMessageDTOs(outboxList);
    }

    @RequestMapping(path = "/mark_read", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
    public void markRead(@RequestBody MessageDto messageDto) throws Exception {
        System.out.println(messageDto);
        Message message = MessageMapper.convertMessageDtoToEnitry(messageDto);

        message.setHasRead(true);

        messageRepository.save(message);

        messageRepository.flush();

    }

    @RequestMapping(path = "/get_unread/{idReceiver}", method = RequestMethod.GET,  produces = "text/plain")
    public String getUnread(@PathVariable int idReceiver) throws Exception {


        String messageCount = messageRepository.getUnreadMessages(idReceiver);

        return messageCount;
    }



    @RequestMapping(path = "/get_bids/{idUser}", method = RequestMethod.GET,  produces = "text/plain")
    public List<BidDto> getBids(@PathVariable int idUser) throws Exception {


        List<Bids> bids = bidRepository.findAll();

        return convertToBidsDTOs(bids);
    }


    @RequestMapping(path="/place_bid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void place_bid(@RequestBody BidDto bidDto) throws Exception {

        System.out.println(bidDto);

        Item item = itemRepository.findItemByItemId(bidDto.getItemId());

        System.out.println(item);

        item.setCurrently(bidDto.getOfferPrice());

        item.setNumberOfBids(item.getNumberOfBids() + 1);

        itemRepository.save(item);
        itemRepository.flush();

        Bids bid = BidMapper.registerDtoToBid(bidDto);
        bid.setItem(item);
        bidRepository.save(bid);
        bidRepository.flush();



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
            UploadFileResponseDto uploadFileResponseDto = new UploadFileResponseDto();
            uploadFileResponseDto.setPath(path);

            return uploadFileResponseDto;
        } else {
            return null;
        }

    }



    @RequestMapping(path="/importXml", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void importXml() throws Exception{
    	try {
        	//	C:\\Users\dimitris\git\auctioneer\src\main\resources\ebay-data\ebay-data\items-0.xml
        		File file = new File("src/main/resources/ebay-data/ebay-data/items-0.xml");
        		JAXBContext jaxbContext = JAXBContext.newInstance(ItemsJax.class);

        		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        		ItemsJax itemsJax = (ItemsJax) jaxbUnmarshaller.unmarshal(file);



        		for (ItemJax itemJax: itemsJax.getItem()){
        			//itemJax.get



        		}



        		System.out.println(itemsJax);

        	  } catch (JAXBException e) {
        		e.printStackTrace();
        	  }

    }


    @RequestMapping(path="/exportXml", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public byte [] exprortXml() throws Exception{

    	  try {
              ItemsJax items = new ItemsJax();
              items.getItem().addAll(itemRepository.findAll().stream().map(ItemMapper::item2ItemJax).collect(Collectors.toList()));
              JAXBContext jaxbContext = JAXBContext.newInstance(ItemsJax.class);
              Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
              jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

              ByteArrayOutputStream bos = new ByteArrayOutputStream();
              jaxbMarshaller.marshal(items, bos);
              return bos.toByteArray();
          } catch (JAXBException e) {
              e.printStackTrace();
          }
          return null;
      }



    @RequestMapping(path = "/update_auction", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ItemAddResponseDto updateAuction(@RequestBody ItemAddRequestDto itemAddRequestDto) throws Exception {

        System.out.println(itemAddRequestDto);
        Item item = ItemMapper.registerRequestToItem(itemAddRequestDto);
        item.setUser(userRepository.findUserByUserId(itemAddRequestDto.getSellerId()));
        System.out.println(item);
        itemRepository.save(item);
        itemRepository.flush();

        List<CategoryDto> categories = itemAddRequestDto.getCategories();

        categories.forEach(category -> {
            ItemCategory categoryEntity = new ItemCategory();

            // FIXME: This is really not good. Should be done with jpa.
            categoryEntity.setCategoryId(category.getId());
            categoryEntity.setItemId(item.getItemId());

            itemCategoryRepository.save(categoryEntity);
            itemCategoryRepository.flush();
        });


        List<String> photos = itemAddRequestDto.getPhotos();


        photos.forEach(photo -> {
            Photos photosEntity = new Photos();

            photosEntity.setItemByItemid(item);
            photosEntity.setPhotoPath(photo);


            photosRepository.save(photosEntity);
            photosRepository.flush();
            System.out.println(photosEntity);
        });



        // Create dummy response
        ItemAddResponseDto itemAddResponseDto = new ItemAddResponseDto();
        itemAddResponseDto.setItemId(item.getItemId());

        return itemAddResponseDto; // TODO: Return something meaningful.

    }


    @ExceptionHandler(Exception.class)
    public void notFound(HttpServletResponse e) throws Exception {
        e.sendError(HttpStatus.NOT_FOUND.value());
    }

}
