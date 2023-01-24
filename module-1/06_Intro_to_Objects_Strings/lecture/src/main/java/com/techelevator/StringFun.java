package com.techelevator;
import java.util.Locale;
import java.util.Scanner;
public class StringFun {
    public static void main(String[] args) {
        String fx = new String("myvalue");
        String hello = "hello world";

        //length
        String allSpaces = "     ";
        System.out.println(hello.length());
        System.out.println("".length());
        System.out.println(allSpaces.length());
        if (allSpaces.length() > 0) {
            //does something
        }
        System.out.println(hello.substring(6));//returns "world"
        System.out.println(hello.substring(6, 7));//returns "w"
        System.out.println(hello.substring(6, hello.length()));

       // for (int i = 0; i < hello.length(); i++) {
         //   System.out.println(hello.substring(i,i+=1));// ++i(SAME AS i + 1) I IS RETURNED AND THEN INCREMENTED

        System.out.println(hello.indexOf("world"));
        System.out.println(hello.indexOf("o"));
        System.out.println(hello.indexOf("o", 5));
        System.out.println(hello.indexOf("not found")); //-1 if not found i the string

        //charAt()
       char theE = hello.charAt(1);
        System.out.println(theE);
        if (hello.charAt(1) == 'e') {
            //do something
        }

        //contains-----to uppercase and tolowercase
        System.out.println(hello.contains("wor"));
        System.out.println(hello.contains("foo"));
        System.out.println(hello.contains("WOR".toLowerCase()));

        String lowerValue = "WOR".toLowerCase();
        hello.contains(lowerValue);

        //starts with and ends with
        System.out.println(hello.startsWith("hel"));
        System.out.println(hello.endsWith("d"));
        System.out.println(hello.endsWith("xxxx"));

        System.out.println(hello.toUpperCase());
        System.out.println("THIS IS ALL UPPER".toLowerCase());

        System.out.println("is this F or C");
      //  Scanner userInput = new Scanner (System.in);
        //String tempType = userInput.nextLine();
        //if (tempType.toUpperCase().contains("F")) {

     //   }
        //replace
        System.out.println(hello.replace("hello", "goodbye" ));
        System.out.println(hello);//hello is not changes because they are immutable

        String nums = "1,2,3,4,5,6";
        String[] parts = nums.split(" ");
        System.out.print(String.join(",", parts));
        }
    }

