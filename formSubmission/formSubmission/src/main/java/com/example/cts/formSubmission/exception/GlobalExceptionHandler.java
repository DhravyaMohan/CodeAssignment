package com.example.cts.formsubmission.exception;

import com.example.cts.formsubmission.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @ExceptionHandler(UserNotFoundException.class)
        public ResponseEntity<ErrorResponse> userHandler(Exception ex, WebRequest request) {
        LOGGER.error("Exception",ex);
        ErrorResponse error=new ErrorResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setError(ex.getMessage());
        error.setDetails(request.getDescription(false));
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

        }


    @ExceptionHandler(UserManagementException.class)
    public ResponseEntity<ErrorResponse> userDetailHandler(Exception ex, WebRequest request){
        LOGGER.error("Exception",ex);
        ErrorResponse error=new ErrorResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setError(ex.getMessage());
        error.setDetails(request.getDescription(false));
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }
    }

