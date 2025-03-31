package com.projetreseau.chatbot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetreseau.chatbot.models.User;

 
@Repository
public interface UserRepository extends MongoRepository<User,String>{

    
}
