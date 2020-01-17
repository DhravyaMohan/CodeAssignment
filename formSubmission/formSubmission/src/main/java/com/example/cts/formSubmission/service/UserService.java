package com.example.cts.formsubmission.service;

import com.example.cts.formsubmission.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

     List<User> readAllUser();
     User createUser(User user) ;
     void updateUser(User userDetails) ;
     void deleteUser(Long id);


}
