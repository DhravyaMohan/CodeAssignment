package com.example.cts.formSubmission.service;

import com.example.cts.formSubmission.bean.User;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

@Service
public interface UserService {
     String createUser(User user) ;
     String deleteUser(Long id)throws FileNotFoundException;
     List<User> readAllUser();


}
