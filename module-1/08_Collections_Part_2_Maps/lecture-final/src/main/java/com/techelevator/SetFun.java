package com.techelevator;

import java.util.HashSet;
import java.util.Set;

public class SetFun {
    public static void main(String[] args) {

        // unordered collection of unique values
        Set<String> names = new HashSet<>();
        names.add("jon");
        names.add("chris");
        names.add("ray");

        System.out.println(names);
        System.out.println("was Ray added? " + names.add("ray"));
        System.out.println(names);

        names.remove("ray");
        System.out.println(names);

        System.out.println("is Ray in the list of name? " + names.contains("ray"));

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        System.out.println(set1.equals(set2));
        set2.remove(4);
        System.out.println(set1.equals(set2));

        for(String name : names) {
            System.out.println(name);
        }





    }
}
