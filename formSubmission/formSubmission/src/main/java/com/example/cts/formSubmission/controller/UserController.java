package com.example.cts.formSubmission.controller;

import com.example.cts.formSubmission.bean.User;
import com.example.cts.formSubmission.service.UserServiceImpl;

import javax.validation.Valid;

import java.io.FileNotFoundException;
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
    //private UserRepository userRepository;

    //creating a new user
    @PostMapping("/createuser")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveUser(@RequestBody User user) {
        LOGGER.info("UserController::CreateUser:::");
        LOGGER.debug("user json -> {}",user);
        userService.createUser(user);
        return "success";
    }

    //deleting an existing user
    @DeleteMapping("/deleteuser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@PathVariable(value = "id") Long id) throws FileNotFoundException {
        LOGGER.info("UserController::deleteUser:::");
        userService.deleteUser(id);

        return "deleted";

    }

    //Updating an existing user
    @PutMapping("/updateuser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity < User > updateUser(@PathVariable(value = "id") Long id,
                                              @Valid @RequestBody User userDetails) throws FileNotFoundException {

        return userService.updateUser(id,userDetails);

    }

    //reading the user table records
    @GetMapping("/getallusers")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.readAllUser();

        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    //getting user information by id
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getEmployeeById(@PathVariable("id") Long id)
//            throws FileNotFoundException {
//        User user = userService.getUserById(id);
//
//        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
//    }


}
