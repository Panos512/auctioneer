package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.AuthenticationException;


@ResponseStatus(code= HttpStatus.NON_AUTHORITATIVE_INFORMATION,  value = HttpStatus.NON_AUTHORITATIVE_INFORMATION)
public class Unauthorized extends AuthenticationException {


    public Unauthorized(String message) {
        super(message);
        System.out.println(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        System.out.println("401 " + message);

    }
}

