package com.projetreseau.chatbot.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection="messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    
    @Id
    String messageId;
    String messageBody;
    String SenderUsername;
    String category;
    String time;
}
