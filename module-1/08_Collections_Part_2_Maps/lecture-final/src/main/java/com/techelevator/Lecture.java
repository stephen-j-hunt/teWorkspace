package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lecture {

    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();
        scores.put("ray", 3);
        scores.put("david", 3);
        scores.put("chris", 3);

        System.out.println(scores);

        scores.put("chris", 2);
        System.out.println(scores);

        System.out.println("Ray's score is: " + scores.get("ray"));

        System.out.println("number of scores: " + scores.size());
        System.out.println("Are there any scores " + !scores.isEmpty());

        if (scores.size() != 0) {

        }
        if (!scores.isEmpty()) {

        }

        scores.remove("chris");
        System.out.println(scores);

        // iterating through a Map, if needed
        // for each key in the set of keys within the Map
        for(String key : scores.keySet()) {
            System.out.printf("%s : %s\n", key, scores.get(key));
        }

        System.out.println("is there a score of 3? " + scores.containsValue(3));
        System.out.println("is there a score for Chris? " + scores.containsKey("chris"));

        System.out.println("is there a score for david? " + scores.containsKey("david"));
        System.out.println("is there a score for David? " + scores.containsKey("David"));

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1,"A");
        map1.put(2,"B");
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(1,"A");
        System.out.println("are equal? " + map1.equals(map2));

        // not equal since <2,C> is not in Map1
        map2.put(2,"C");
        System.out.println("are equal now? " + map1.equals(map2));

        // now equal with same number of items with the same keys and the same values
        map2.put(2,"B");
        System.out.println("are equal now? " + map1.equals(map2));

        Map<String, String> map3 = new HashMap<>();




    }

}
