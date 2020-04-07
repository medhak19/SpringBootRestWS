package com.rest.api.service.impl;

import com.rest.api.Application;
import com.rest.api.model.User;
import com.rest.api.service.MemoryMap;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration
@WebAppConfiguration
public class MemoryMapTest {

    @Autowired
    MemoryMapImpl memoryMap;



    @Test
    public void createUserTest(){
        User user = new User("Medha","Kamalakar");
        memoryMap.createUser(user);
        Assert.assertEquals(user.getFirstName(), memoryMap.retrieveUser(user.getFirstName()).getFirstName());
        Assert.assertEquals(user.getLastName(), memoryMap.retrieveUser(user.getFirstName()).getLastName());

    }

    @Test
    public void retrieveUserTest(){
        User user = new User("Arjun","Kamalakar");
        memoryMap.createUser(user);
        User u = memoryMap.retrieveUser(user.getFirstName());
        Assert.assertEquals(user.getFirstName(),u.getFirstName());
        Assert.assertEquals(user.getLastName(),u.getLastName());
    }

    @Test
    public void getUserListTest(){
        int countBefore = memoryMap.getUsersCount();
        memoryMap.createUser(new User("Malhar","Kamalakar"));
        int countAfter = memoryMap.getUsersCount();
        Assert.assertEquals(countBefore+1,countAfter);
    }
}


