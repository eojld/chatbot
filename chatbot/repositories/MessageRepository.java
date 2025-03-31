package com.projetreseau.chatbot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projetreseau.chatbot.models.Message;

public interface MessageRepository extends MongoRepository<Message,String>{

    
}
 
