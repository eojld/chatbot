package com.projetreseau.chatbot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projetreseau.chatbot.models.Response;

public interface ResponseRepository extends MongoRepository<Response,String>{

    
}