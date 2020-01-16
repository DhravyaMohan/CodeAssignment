package com.example.cts.formSubmission.exception;

public class UserListNotFoundException extends RuntimeException {

    public UserListNotFoundException(String message) {

        super(message);
    }

    public UserListNotFoundException(String message,Throwable e) {
        super(message,e);
    }
}
