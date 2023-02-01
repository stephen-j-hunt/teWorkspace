package com.techelevator.farm;

import java.util.HashMap;
import java.util.Map;

public class Kata {

    public static void main(String[] args) {
        System.out.println("son and soon: " + isAnagram("son", "soon")); //should be false
        System.out.println("part and trap: " + isAnagram("part", "trap"));//should be true
    }
    public static boolean isAnagram(String str1,String str2) {


        if (str1.length() != str2.length()) {
            return false;

        }
        Map<String,Integer> counts= new HashMap<String,Integer>();
        String[] word1= str1.split("");
        for (String letter:word1){
            if (counts.containsKey(letter)) {
                String=counts.get(letter);
                System.out.println();
            }
        }
    }
}
