/**
 * Created by Panos on 25/7/16.
 */
package com.mappers;


import com.dto.UserSignUpRequestDto;
import com.dto.UserDto;
import com.entity.Users;


public class UserMapper {

    public static Users registerRequestToUser(UserSignUpRequestDto userSignUpDto) {

        if (userSignUpDto == null)
            return null;

        Users user = new Users();
        user.setUsername(userSignUpDto.getUsername());
        user.setEmail(userSignUpDto.getMail());
        user.setPassword(userSignUpDto.getPassword());
        user.setFirstName(userSignUpDto.getFirst_name());
        user.setLastName(userSignUpDto.getLast_name());
        user.setPhone(userSignUpDto.getPhone_number());
        user.setAfm(userSignUpDto.getAfm());
        user.setLatitude(userSignUpDto.getLatitude());
        user.setLongitude(userSignUpDto.getlongitude());
        user.setAddress(userSignUpDto.getAddress());
        user.setRole("user");
        user.setGender(userSignUpDto.getGender());
        user.setVerified(false);
        user.setBuyerRating(0.0);
        user.setSellerRating(0.0);
        return user;
    }


    public static UserDto registerUsersToUser(Users user) {

        if (user == null)
            return null;

        UserDto  userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUsername(user.getUsername());
        userDto.setMail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setFirst_name(user.getFirstName());
        userDto.setLast_name(user.getLastName());
        userDto.setPhone_number(user.getPhone());
        userDto.setAfm(user.getAfm());
        userDto.setLatitude(user.getLatitude());
        userDto.setlongitude(user.getLongitude());
        userDto.setAddress(user.getAddress());
        userDto.setRole(user.getRole());
        userDto.setGender(user.getGender());
        userDto.setVerified(user.getVerified());
        userDto.setBuyerRating(user.getBuyerRating());
        userDto.setSellerRating(user.getSellerRating());

        return userDto;
    }
}
