package com.projetreseau.chatbot.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetreseau.chatbot.models.User;
import com.projetreseau.chatbot.repositories.UserRepository;






@Service
public class UserService {


	@Autowired
	private UserRepository userRepository;

    public User saveUser(User user) {
        
        user.setUserId(UUID.randomUUID().toString().split("-")[0]);
        user.setFirstname(user.getFirstname());
        user.setLastname(user.getLastname());
        return userRepository.save(user);
    }

    
    
}
