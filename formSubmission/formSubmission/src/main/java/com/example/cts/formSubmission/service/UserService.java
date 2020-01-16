package com.example.cts.formSubmission.service;

import com.example.cts.formSubmission.bean.User;
import com.example.cts.formSubmission.exception.UserListNotFoundException;
import com.example.cts.formSubmission.exception.UserManagementException;
import com.example.cts.formSubmission.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

@Service
public interface UserService {

     List<User> readAllUser();
     User createUser(User user) ;
     void updateUser( Long id, User userDetails) ;
     void deleteUser(Long id);


}
