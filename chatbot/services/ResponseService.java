package com.projetreseau.chatbot.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetreseau.chatbot.models.Response;
import com.projetreseau.chatbot.repositories.ResponseRepository;

@Service
public class ResponseService {

    @Autowired
	private ResponseRepository responseRepository;

    public Response saveMessage(Response response) {

        response.setResponseId(UUID.randomUUID().toString().split("-")[0]);
        response.setResponse(response.getResponse());
        response.setTime(response.getTime());               
        return responseRepository.save(response);
    }
    
}
