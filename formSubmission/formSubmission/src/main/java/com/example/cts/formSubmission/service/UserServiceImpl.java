package com.example.cts.formsubmission.service;

import com.example.cts.formsubmission.bean.User;
import com.example.cts.formsubmission.exception.UserManagementException;
import com.example.cts.formsubmission.exception.UserNotFoundException;
import com.example.cts.formsubmission.repository.UserRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    //creating a new user
    public User createUser(User user) {
        logger.debug("UserService::createUser:::");
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new UserManagementException("Exception occurred while saving the user details", e);
        }
    }

    //deleting an existing user
    public void deleteUser(Long id) {
        logger.debug("UserService::deleteUser:::");
        User user = findByUserId(id);
        userRepository.delete(user);

    }

    //getting all users
    public List<User> readAllUser() {
        logger.debug("UserService::readUser:::");
        List<User> user = userRepository.findAll();

        if (!user.isEmpty()) {
            return user;
        }

        throw new UserNotFoundException("No Users Found");
    }

    //Updating an existing user
    public void updateUser(User userDetails) {
        logger.debug("UserService::updateUser:::");
        User user = findByUserId(userDetails.getId());
        try {
            userRepository.save(populateUser(userDetails, user));
        } catch (Exception e) {
            throw new UserManagementException("Exception occurred while saving the user details", e);
        }
    }

    private User findByUserId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found for this id :: " + id));
    }

    private User populateUser(User userDetails, User user) {
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmailId(userDetails.getEmailId());
        user.setAddress(userDetails.getAddress());
        user.setContactNo(userDetails.getContactNo());
        user.setAge(userDetails.getAge());
        return user;
    }
}

