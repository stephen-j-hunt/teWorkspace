package com.techelevator;

public class StringFun {
    public static void main(String[] args) {
        int p = 0; // ints are in the stack
        String hello = "hello"; // strings stored in the heap
        String hello2  ="hello";
        String world = "world";
        String expected = "hello world";
        String full = hello + " " + world;
        System.out.println(hello == hello2); /////works due to string interning
        System.out.println(expected == full);
        System.out.println(expected.equals(full));/// compare with .equals() FTW
        ///uppercase and lowercase letters are 2 different values
        System.out.println(expected.equalsIgnoreCase(full));

        ///you can use .length to campare the length of strings just use () world.length()


        //////string made of multiple componenets and want to split them up

        String words =  "one, two, three, four";
        String wordsArr[] = words.split(",");//////control q to view regex method info
        for (int i = 0; i < wordsArr.length;i++) {
            System.out.println(wordsArr[i]);

            /////strings are immutable meaning they can not be modified/////
        }
       String allUpper= expected.toUpperCase();
        System.out.println("allUpper= " +allUpper);
        System.out.println("expected= " + expected);


        String one = "1"; /////this is a number but cant do math in a string java sees this as string with codes in it////
       // int total = 4-one;///this does not work but JAVA HAS WAY TO THIS BY PARSING
        int total = 4- Integer.parseInt(one); ////int, long, double, float are primitve data types to treat them as reference we need CONTAINER to put them in
        System.out.println("the result is: " + total);
        double ten = 10;
        Double tenWrapper = 10.0;
        double backToTen = tenWrapper; // move between WRAPPER=OBJECT and PRIMITIVE=not an object
        //the WRAPPER wraps a PRIMITIVE and lets you use it as an object
    }
}
