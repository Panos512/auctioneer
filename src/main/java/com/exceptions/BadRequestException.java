package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.AuthenticationException;

/**
 * Created by dimitris on 7/30/16.
 */

@ResponseStatus(code= HttpStatus.BAD_REQUEST,  value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends AuthenticationException {


    public BadRequestException(String message) {
        super(message);


    }
}

