package com.example.cts.formSubmission.service;

import com.example.cts.formSubmission.FormSubmissionApplication;
import com.example.cts.formSubmission.bean.User;
import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

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
        public void init(){
                System.out.println("init done");
        }

        @Test
        @Order(1)
        public void testGetAllUsers() {
                HttpHeaders headers = new HttpHeaders();
                HttpEntity<String> entity = new HttpEntity<String>(null, headers);
                String getResponse = restTemplate.getForObject(getUrl() + "/UserManagement/users/getallusers", String.class);
                System.out.println("getResponse===>"+getResponse);
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
                ResponseEntity<User> postResponse = restTemplate.postForEntity(getUrl() + "/UserManagement/users/createuser", user, User.class);
                user=postResponse.getBody();
                this.setId(user.getId());
                System.out.println("id===>"+this.getId());
                assertNotNull(postResponse);
                assertNotNull(postResponse.getBody());
        }


        @Test
        @Order(3)
        public void testUpdateUser() {

                User user = new User();
                user.setFirstName("abcd");
                user.setLastName("abcd");
                user.setEmailId("abs@cts.com");
                user.setAddress("rgbhy");
                user.setContactNo("9876543210");
                user.setAge(10);
                System.out.println("getId1==>"+this.getId());
                restTemplate.put(getUrl() + "/UserManagement/users/updateuser/" + this.getId(), user);
        }

        @Test
        @Order(4)
        public void testDeleteUser() {
                try {
                        System.out.println("getId2==>"+this.getId());
                        restTemplate.delete(getUrl() + "/UserManagement/users/deleteuser/"+ this.getId());
                } catch (final HttpClientErrorException e) {
                        assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
                }

        }

}
