package com.example.cts.formsubmission.exception;

public class UserManagementException extends RuntimeException {
    public UserManagementException(String message) {
        super(message);
    }

    public UserManagementException(String message, Throwable cause) {
        super(message, cause);
    }
}
