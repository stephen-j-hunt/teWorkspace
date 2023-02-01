package com.techelevator.farm;

import java.util.HashMap;
import java.util.Map;

public class Kata {

    public static void main(String[] args) {

        System.out.println("son and soon: " + isAnagram("son", "soon")); // should be false
        System.out.println("part and trap: " + isAnagram("part", "trap")); // should be true

    }

    public static boolean isAnagram(String str1, String str2) {
        // you will make this work
        if (str1 == null || str1.isBlank()) return false;
        if (str2 == null || str2.isBlank()) return false;
        if (str1.equalsIgnoreCase(str2)) return false;
        
        return string2Map(str1.toLowerCase()).equals(string2Map(str2.toLowerCase()));
    }

    private static Map<String, Integer> string2Map(String str) {
        final String[] letters = str.split("");
        final Map<String, Integer> result = new HashMap<>();
        for (String letter : letters) {
            if (!result.containsKey(letter)) {
                result.put(letter, 1);
            } else {
                result.put(letter, result.get(letter)+1);
            }
        }
        return result;
    }

}
