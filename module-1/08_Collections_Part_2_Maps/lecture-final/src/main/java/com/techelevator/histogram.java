package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class histogram {
    public static void main(String[] args) {

        /*
        1. count frequency of the letters
            scan through the string
                for()
                substring
            increment a counter for each letter
                Map letter,count
        2. graph counts
            display in alpah order
            remove non-letter characters
            loop ?????
            repeat # the appropriate number of times
         */

        String result = from("you are screen sharing");
        System.out.println(result);


    }

    public static String from(String s) {

        // count all the letters
        Map<String, Integer> counts = new HashMap<>();
        String str = s.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            String letter = str.substring(i, i + 1);
            int currentCount = 0;
            if (counts.containsKey(letter)) { // have we seen this letter before
                currentCount = counts.get(letter); // works if the letter has been seen before
            }
            counts.put(letter, currentCount + 1);
        }

        // build the graph
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String result = "";
        for (int i = 0; i < letters.length(); i++) {
            String letter = letters.substring(i, i + 1);
            if (counts.containsKey(letter)) {
                int count = counts.get(letter);
                String bar = "#".repeat(count);
                result += letter + ": " + bar + "\n";
            }
        }

        return result;
    }

}
