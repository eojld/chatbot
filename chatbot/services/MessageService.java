package com.projetreseau.chatbot.services;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetreseau.chatbot.models.Message;
import com.projetreseau.chatbot.repositories.MessageRepository;
import com.projetreseau.chatbot.services.ChatbotUtils.BotResponse;

@Service
public class MessageService {

    @Autowired
	private MessageRepository messageRepository;

    

    public  String categorize(Message message) {
 
        BotResponse botResponse = new BotResponse();        
        
        String category ="";

        try {
            category = botResponse.findCategory(message.getMessageBody());
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  category;         
    }


    public Message saveMessage(Message message, String category){

        message.setMessageId(UUID.randomUUID().toString().split("-")[0]);
        message.setMessageBody(message.getMessageBody());
        message.setTime(message.getTime());
        message.setCategory(category);
        message.setSenderUsername(message.getSenderUsername());
        messageRepository.save(message);
        System.out.println("Message categorized and saved!!");

        return message;

    }


    
}




    
    
