package com.controller;


import com.dao.UserRepository;
import com.dto.UserLogInRequestDto;
import com.dto.UserLogInResponseDto;
import com.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
public class MainCtrl {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path="/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public UserLogInResponseDto login(@RequestBody UserLogInRequestDto userLogInRequestDto) {
        List<Users> user = userRepository.findUserByUsernameAndPassword(userLogInRequestDto.getUsername(), userLogInRequestDto.getPassword());

        if (user.isEmpty())
            return null;

        UserLogInResponseDto userLogInResponseDto = new UserLogInResponseDto();
        userLogInResponseDto.setUserId((long) user.get(0).getUserId());

        return userLogInResponseDto;
    }

}
