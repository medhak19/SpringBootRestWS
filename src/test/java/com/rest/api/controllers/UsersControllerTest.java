package com.rest.api.controllers;

import com.rest.api.model.User;
import com.rest.api.service.impl.MemoryMapImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersControllerTest {

    @Bean
    public TestRestTemplate testRestTemplate() {
        return new TestRestTemplate();
    }

    @Autowired
    MemoryMapImpl memoryMap;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void createUserTest(){
        User user = new User("Malhar","Kamalakar");

        HttpEntity<User> entity = new HttpEntity(user);
        ResponseEntity<String> result = testRestTemplate.postForEntity("/v1/user",entity,String.class);
        Assert.assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());
        assertEquals("User created. First name: "+ user.getFirstName() + " :: Last name: " + user.getLastName(), result.getBody().toString());

    }

    @Test
    public void getUserTest(){

        User u = new User("Rugved","Kamalakar");
        memoryMap.createUser(u);

        ResponseEntity<User> result = testRestTemplate.getForEntity("/v1/user?name=Rugved",User.class);

        Assert.assertNotNull(result);
        Assert.assertEquals(HttpStatus.OK,result.getStatusCode());

        Assert.assertEquals(u.getFirstName(),result.getBody().getFirstName());
        Assert.assertEquals(u.getLastName(),result.getBody().getLastName());

    }



    @Test
    public void getUserListTest(){
        int beforeCount = memoryMap.getUsersCount();
        User u = new User("Arjun","Kamalakar");
        memoryMap.createUser(u);

        User[] result = testRestTemplate.getForObject("/v1/userList",User[].class);



        Assert.assertNotNull(result);

        Assert.assertEquals(beforeCount+1,result.length);

    }
}
