package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.AuthenticationException;


@ResponseStatus(code= HttpStatus.FORBIDDEN,  value = HttpStatus.FORBIDDEN)
public class AccessDenied extends AuthenticationException {


    public AccessDenied(String message) {
        super(message);
        System.out.println(HttpStatus.FORBIDDEN);
        System.out.println("403 " + message);

    }
}

