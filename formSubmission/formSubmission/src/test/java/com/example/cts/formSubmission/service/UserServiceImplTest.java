package com.example.cts.formSubmission.service;

import com.example.cts.formSubmission.FormSubmissionApplication;
import com.example.cts.formSubmission.bean.User;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertNotNull;


@SpringBootTest(classes = FormSubmissionApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceImplTest {

        @Autowired
        private TestRestTemplate restTemplate;

        @LocalServerPort
        private int port;

        private String getUrl() {
                return "http://localhost:" + port;
        }

        @Before
        public void init(){
                System.out.println("init done");
        }

        @Test
        public void testGetAllUsers() {
                HttpHeaders headers = new HttpHeaders();
                HttpEntity<String> entity = new HttpEntity<String>(null, headers);
                ResponseEntity<String> response = restTemplate.exchange(getUrl() + "/users",
                        HttpMethod.GET, entity, String.class);
                assertNotNull(response.getBody());
        }

        @Test
        public void testCreateUser() {
                User user = new User();
                user.setFirstName("admin");
                user.setLastName("admin");
                user.setEmailId("admin@gmail.com");
                user.setAddress("xyz");
                user.setContactNo("9977553311");
                user.setAge(11);
                ResponseEntity<User> postResponse = restTemplate.postForEntity(getUrl() + "/users/createuser", user, User.class);
                assertNotNull(postResponse);
                assertNotNull(postResponse.getBody());
        }

}
