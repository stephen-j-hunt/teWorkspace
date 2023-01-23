package com.techelevator;

public class StringFun {
    public static void main(String[] args) {
        int p = 0;
        String hello = "hello";
        String hello2 = "hello";
        String world = "world";
        String expected = "hello world";
        String full = hello + " " + world;
        System.out.println(hello == hello2); // works due to String Interning
        System.out.println(expected == full);
        System.out.println(expected.equals(full)); // compare with .equals() FTW
        System.out.println(expected.equalsIgnoreCase(full));

        String words = "one,two,three,four";
        String wordArr[] = words.split(",");
        for(int i=0; i<wordArr.length; i++) {
            System.out.println(wordArr[i]);
        }

        String allUpper = expected.toUpperCase();
        System.out.println("allUpper= " + allUpper);
        System.out.println("expected= " + expected);

        String one = "1";
        // int total = 4-one; won't work
        int total = 4 - Integer.parseInt(one);
        System.out.println("the result is: " + total);

        double ten = 10;
        Double tenWrapper = 10.0;
        double backToTen = tenWrapper;
    }
}
