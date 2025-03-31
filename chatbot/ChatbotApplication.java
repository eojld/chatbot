package com.projetreseau.chatbot;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.event.EventListener;

import com.projetreseau.chatbot.services.ChatbotUtils.BotResponse;


@SpringBootApplication
public class ChatbotApplication  {

    
	@Autowired
	BotResponse botResponse;

	


		
	public static void main(String[] args) {
		SpringApplication.run(ChatbotApplication.class, args);
	}
    
	
// 	@EventListener(ApplicationReadyEvent.class)
//   	public void doSomethingAfterStartup() {
//     System.out.println("hello world, I have just started up");
// 	try {
// 		botResponse.modelsInitialization();


// 	} catch (Exception e) {
// 		// TODO Auto-generated catch block
// 		e.printStackTrace();
// 	}
// }



	// @Override
	// public void run(String... args) throws Exception {
	// 	// TODO Auto-generated method stub

	// 	try {
	// 		botResponse.modelsInitialization();
	
	
	// 	} catch (Exception e) {
	// 		// TODO Auto-generated catch block
	// 		e.printStackTrace();
	// 	}
	
	// }

}
