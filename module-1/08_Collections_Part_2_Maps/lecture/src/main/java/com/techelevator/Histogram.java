package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Histogram {
    public static void main(String[] args) {
        /*
        CREATING A HISTOGRAM
         1. count the frequency of the letters
         scan through the string
         for()
         substring
         increment a counter for each letter
         Map letter, count
         2. graph counts
    */
    String result = from("you are screen sharing");
    }
    public static String from(String str) {
        Map<String, Integer> counts = new HashMap<>();
        for (int i =0;i<str.length();i++) {
           String letter = str.substring(i,i+1);
           counts.put(letter, counts.get(letter)+1);
        }
        return null;
    }
}
