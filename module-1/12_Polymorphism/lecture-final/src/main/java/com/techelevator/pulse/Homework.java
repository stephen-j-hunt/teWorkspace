package com.techelevator.pulse;

import java.util.*;

public class Homework {

    /*
     * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
     * is true only if that String appears 2 or more times in the array.
     *
     * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
     * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
     * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
     *
     */
    public Map<String, Boolean> wordMultiple(String[] words) {

        Map<String, Boolean> wordMultiple = new HashMap<>();
        for (String word : words) {
            if (wordMultiple.containsKey(word)) {
                wordMultiple.put(word, true);
            } else {
                wordMultiple.put(word, false);
            }
        }

        return wordMultiple;
    }

    private List<String> additions;
    public void question() {
        String[] additions = {};

        List<Integer> myList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        int[] myArray = {1,2,3,4,5};

        this.additions.addAll(Arrays.asList(additions));
    }

    public String toString() {
        String size = "";
        String blend = "";
        String[] additions = {};
        double price = 0;
        return size + " coffee, "
                + blend
                + " (" + String.join(",", additions) + "). Price: $"
                + price;
    }
}
