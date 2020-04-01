package com.rest.api.controllers;

import com.rest.api.model.User;
import com.rest.api.service.MemoryMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserMgmt {

    @Autowired
    MemoryMap memoryMap;

    @PostMapping(value = "/v1/user", produces = {MediaType.TEXT_PLAIN_VALUE},
            consumes = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> createUser(@RequestBody User user){

        memoryMap.createUser(user);
        return ResponseEntity.accepted().body("User created. First name: " + user.getFirst_name() + " :: Last name: " + user.getLast_name());
    }


    @GetMapping(value = "/v1/user", produces = {"application/json"})
    public ResponseEntity<User> getUser( @RequestParam(value="name", defaultValue="Medha") String userID){
        User user = memoryMap.retrieveUser(userID);

        return ResponseEntity.ok()
                .body(user);

    }

    @GetMapping(value = "/v1/userList", produces = {"application/json"})
    public ResponseEntity<List<User>> getUser(){
        List<User> users = memoryMap.getUserList();

        return ResponseEntity.ok()
                .body(users);

    }
}
