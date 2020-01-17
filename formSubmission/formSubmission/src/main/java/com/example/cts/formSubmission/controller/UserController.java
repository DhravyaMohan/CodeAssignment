package com.example.cts.formsubmission.controller;

import com.example.cts.formsubmission.bean.User;
import com.example.cts.formsubmission.service.UserServiceImpl;

import javax.validation.Valid;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    //creating a new user
    @PostMapping("/createuser")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        LOGGER.info("UserController::CreateUser:::");
        return userService.createUser(user);
    }

    //deleting an existing user
    @DeleteMapping("/deleteuser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable(value = "id") Long id)  {
        LOGGER.info("UserController::deleteUser:::");
        userService.deleteUser(id);
    }

    //Updating an existing user
    @PutMapping("/updateuser")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@Valid @RequestBody User userDetails) {

        LOGGER.info("UserController::UpdateUser:::");
        userService.updateUser(userDetails);

    }

    //reading the user table records
    @GetMapping("/getallusers")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<User>> getAllUsers() {
        LOGGER.info("UserController::GetAllUser:::");
        List<User> list = userService.readAllUser();

        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }


}
