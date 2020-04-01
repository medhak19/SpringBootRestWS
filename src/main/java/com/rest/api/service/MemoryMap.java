package com.rest.api.service;

import com.rest.api.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MemoryMap {

    public void createUser(User user);
    public User retrieveUser(String userId);

    public List<User> getUserList();
}
