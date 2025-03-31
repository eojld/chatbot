package com.projetreseau.chatbot.controllers.utils;



import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LocationUtils {


   

public static List<String> findClosestStrings(String givenString, ArrayList<String> stringSet, int k) {
    PriorityQueue<StringDistancePair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));
    
    for (String str : stringSet) {
        double distance = calculateDistance(givenString, str); // Replace with your chosen similarity measure or distance metric
        pq.offer(new StringDistancePair(str, distance));
        
        if (pq.size() > k) {
            pq.poll();
        }
    }
    
    List<String> closestStrings = new ArrayList<>();
    while (!pq.isEmpty()) {
        closestStrings.add(0, pq.poll().string);
    }
    
    return closestStrings;
}

private static int calculateDistance(String string1, String string2) {
    int[][] dp = new int[string1.length() + 1][string2.length() + 1];
    
    for (int i = 0; i <= string1.length(); i++) {
        dp[i][0] = i;
    }
    
    for (int j = 0; j <= string2.length(); j++) {
        dp[0][j] = j;
    }
    
    for (int i = 1; i <= string1.length(); i++) {
        for (int j = 1; j <= string2.length(); j++) {
            int cost = string1.charAt(i - 1) == string2.charAt(j - 1) ? 0 : 1;
            dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
        }
    }
    
    return dp[string1.length()][string2.length()];
}


private static class StringDistancePair {
    String string;
    double distance;
    
    public StringDistancePair(String string, double distance) {
        this.string = string;
        this.distance = distance;
    }
}

public static String locationFound(String location){

        String filePath = "locations";
        

        
        ArrayList<String> words = LocationChecker.readWordsFromFile(filePath);

        boolean found = LocationChecker.searchWorld(words, location);
        
        System.out.println("World found: " + found);

        if (found == true){
            return location;        

            
            
        }else{ 
            List<String> closest = LocationUtils.findClosestStrings(location, words, 3);

            return("Incorrect destination! Do you mean "+closest.get(0)+" or "+closest.get(1)+"  ???");               
        
        }


}

    
}
