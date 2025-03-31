package com.projetreseau.chatbot.controllers;
//package com.projetreseau.chatbot.controllers.utils;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.ResponseErrorHandler;

import com.projetreseau.chatbot.controllers.utils.LocationUtils;
import com.projetreseau.chatbot.models.Message;
import com.projetreseau.chatbot.services.MessageService;

@RequestMapping
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;


    static String activateReservationForm = "no";
    static String reservationConfirm ="no";

    static String destinationReservation;
    static String departureReservationForm;

    public static  void setActivateReservationform(String value){
        activateReservationForm = value;
    }

    public static String getActivateReservationForm(){
        return activateReservationForm;
    }

    public static  void setReservationConfirm (String value){
        reservationConfirm = value;
    }

    public static  void setDestinationReservation (String value){
        destinationReservation = value;
    }



    


    
    


    @PostMapping("/messages")
    @ResponseStatus(HttpStatus.CREATED)
    public Message HandleMessage (@RequestBody Message message){ 

        
        // if (reservationConfirm==message.getMessageBody()){
        //     setActivateReservationform("yes");

        //     message.setMessageBody("great! what is your destination?");
        //     return message;
            
        // }else{

            
        
        if (getActivateReservationForm()=="no"){

            String category = messageService.categorize(message);
                     
            Message replyMessage = messageService.saveMessage(message, category);
            
            switch(replyMessage.getCategory()){
                
                case "Booking-inquiry" :
                    
                    replyMessage.setMessageBody("great! what is your destination?");
                    setActivateReservationform("yes");                  
                    return replyMessage;

                case "greetings":

                    replyMessage.setMessageBody("Hello! How can I help you?");
                    return message;

                case "destination-remember":
                    if (destinationReservation==null){
                        replyMessage.setMessageBody("No. you have not yet told me your destination. where do you want to go?");
                        setActivateReservationform("yes"); 
                        return replyMessage;
                    }else{
                        replyMessage.setMessageBody("Yes I remember your destination. you want to go to "+destinationReservation);
                        return replyMessage;
                    }

                case "conversation-continue":
                    replyMessage.setMessageBody("I am happy to help you. Do you have another problem?");
                    return replyMessage;

                case "conversation-complete":
                    replyMessage.setMessageBody("goodbye and have a nice day!");
                    return replyMessage;
                    
                    
                default :
                replyMessage.setMessageBody("I do not understand. Please try be more concised ");
                return message;
            } 
            
        }else{

            String destination = message.getMessageBody() ;
            LocationUtils utils = new LocationUtils();
            if (destination == utils.locationFound(destination)){
                setDestinationReservation(destination);
                setActivateReservationform("no");
                message.setMessageBody("votre destination a été enregistrée! voici les offres pour cette destination....");
                return message;
            }else{


                message.setMessageBody(utils.locationFound(destination));
                return message;
                
            }

                    
        }
        

    }
        
        
       

    

    

}


