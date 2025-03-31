package com.projetreseau.chatbot.controllers.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LocationChecker {
    
    public static ArrayList<String> readWordsFromFile(String filePath) {
        ArrayList<String> words = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+"); // Splitting line by whitespace
                for (String word : lineWords) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return words;
    }


    public static boolean searchWorld(ArrayList<String> worldList, String targetWorld) {
        for (String world : worldList) {
            if (world.equals(targetWorld)) {
                return true;
            }
        }
        return false;
    }



}
