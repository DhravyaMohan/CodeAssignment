package com.example.cts.formsubmission.service;

import com.example.cts.formsubmission.FormSubmissionApplication;
import com.example.cts.formsubmission.bean.User;
import com.example.cts.formsubmission.exception.UserNotFoundException;
import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = FormSubmissionApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceImplTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;
    static long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String getUrl() {
        return "http://localhost:" + port;
    }

    @Before
    public void init() {
        System.out.println("init done");
    }

    @Test
    @Order(1)
    public void testGetAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        String getResponse = restTemplate.getForObject(getUrl() + "/userManagement/users/getallusers", String.class);
        assertNotNull(getResponse);
    }


    @Test
    @Order(2)
    public void testCreateUser() {

        User user = new User();
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setEmailId("admin@gmail.com");
        user.setAddress("xyz");
        user.setContactNo("9977553311");
        user.setAge(11);
        ResponseEntity<User> postResponse = restTemplate.postForEntity(getUrl() + "/userManagement/users/createuser", user, User.class);
        user = postResponse.getBody();
        this.setId(user.getId());
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }


    @Test
    @Order(3)
    public void testUpdateUser() {
        System.out.println("getId1==>" + this.getId());
        User user = new User();
        user.setFirstName("abcd");
        user.setLastName("abcd");
        user.setEmailId("abs@cts.com");
        user.setAddress("rgbhy");
        user.setContactNo("9876543210");
        user.setAge(10);
        user.setId(this.getId());
        HttpEntity<User> entity = new HttpEntity<>(user, new HttpHeaders());
        ResponseEntity<String> response = restTemplate.exchange(getUrl() + "/userManagement/users/updateuser", HttpMethod.PUT, entity, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(4)
    public void testDeleteUser() {

            HttpEntity<String> entity = new HttpEntity<>(null, new HttpHeaders());
            ResponseEntity<String> response = restTemplate.exchange(getUrl() + "/userManagement/users/deleteuser/" + this.getId(), HttpMethod.DELETE, entity, String.class);

            assertEquals(HttpStatus.OK, response.getStatusCode());


    }

    @Test
    @Order(5)
    public void testExceptionThrown() {
        HttpEntity<String> entity = new HttpEntity<>(null, new HttpHeaders());
        ResponseEntity<String> response = restTemplate.exchange(getUrl() + "/userManagement/users/deleteuser/" + this.getId(), HttpMethod.DELETE, entity, String.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

  }
