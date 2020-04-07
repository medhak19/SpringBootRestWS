package com.rest.api.service;

import com.rest.api.model.User;


public interface MemoryMap {

    public void createUser(User user);
    public User retrieveUser(String userId);

    public User[] getUserList();

    public int getUsersCount();
}
