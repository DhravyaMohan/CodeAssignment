package com.example.cts.formSubmission.exception;

public class UserManagementException extends RuntimeException {
    public UserManagementException(String message) {
        super(message);
    }

    public UserManagementException(String message,Throwable e) {
        super(message,e);
    }
}
