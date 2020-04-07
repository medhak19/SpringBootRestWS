package com.rest.api.service.impl;

import com.rest.api.model.User;
import com.rest.api.service.MemoryMap;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemoryMapImpl implements MemoryMap {

    private HashMap<String, User> userHashMap = new HashMap<>();

    public void createUser(User user){
        userHashMap.put(user.getFirstName(), user);
    }
    public User retrieveUser(String userId){
        return userHashMap.get(userId);
    }

    //public List<User> getUserList(){
    public User[] getUserList(){
        //List<User> userList = new ArrayList();

        Set keys = userHashMap.keySet();
        Iterator itr = keys.iterator();
        User[] users = new User[keys.size()];
        int i =0;
        if(itr != null) {
            while (itr.hasNext()) {
                //userList.add(userHashMap.get(itr.next()));
                users[i]=userHashMap.get(itr.next());
                i++;
            }
        }
        //return userList;
        return users;

    }

    public int getUsersCount(){
        return userHashMap.size();
    }

}
