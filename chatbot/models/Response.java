package com.projetreseau.chatbot.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="responses")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Response {    
    @Id
    String ResponseId;
    String Response;
    String time;    
}
