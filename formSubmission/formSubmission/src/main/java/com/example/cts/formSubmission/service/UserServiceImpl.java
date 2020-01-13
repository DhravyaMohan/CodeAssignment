package com.example.cts.formSubmission.service;

import com.example.cts.formSubmission.bean.User;
import com.example.cts.formSubmission.repository.UserRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final static Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    //creating a new user
    public String createUser(User user) {
        logger.info("UserService::createUser:::");
        userRepository.save(user);
        String response="User profile created successfully";
        return response;
    }

    //deleting an existing user
    public String deleteUser(Long id)throws FileNotFoundException{
        logger.info("UserService::deleteUser:::");
        User user = userRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException("Invalid user Id:" + id));
        userRepository.delete(user);
        String response="User profile deleted successfully";
        return response;

    }
    //getting all users
    public List<User> readAllUser(){
        logger.info("UserService::readUser:::");
        List<User> user=userRepository.findAll();
            if(user.size() > 0) {
                return user;
            } else {
                return new ArrayList<User>();
            }
        }

    //Updating an existing user
    public ResponseEntity < User > updateUser( Long id, User userDetails) throws FileNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException("User not found for this id :: " + id));

                user.setFirstName(userDetails.getFirstName());
                user.setLastName(userDetails.getLastName());
                user.setEmailId(userDetails.getEmailId());
                user.setAddress(userDetails.getAddress());
                user.setContactNo(userDetails.getContactNo());
                user.setAge(userDetails.getAge());
        final User updatedUser = userRepository.save(user);
         return ResponseEntity.ok(updatedUser);
    }
}

