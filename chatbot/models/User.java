package com.projetreseau.chatbot.models;


import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;



@Document(collection="users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {    

    @Id
    private String userId;
    @Field 
    private String firstname;
    @Field 
    private String lastname;  

    
    
}
