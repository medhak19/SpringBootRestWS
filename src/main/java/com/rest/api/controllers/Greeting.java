package com.rest.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {

    @RequestMapping("/greeting")
    public String greet(){
        return "Hello World";
    }
}
