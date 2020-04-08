package com.rest.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Greeting {

    @GetMapping(path="/greeting")
    public String greet(){
        return "Hello World ...Medha";
    }
}
