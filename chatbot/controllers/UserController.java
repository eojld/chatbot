package com.projetreseau.chatbot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetreseau.chatbot.models.User;
import com.projetreseau.chatbot.services.UserService;

@RequestMapping
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

   

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
    return ResponseEntity.ok("Hello World!");
}

    





    
}
