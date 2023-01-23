package com.techelevator;

import java.util.Scanner;

public class SimpleCli {
    public static void main(String[] args) {
        final Scanner userInput = new Scanner(System.in);
        // final=once user put value it can't be changed
        // SCANNER exists in the JRE and when using it we have to tell compiler we want line 3

        // promt the user for their name
        System.out.println("what is your name");

        //read the name from the keyboard
        String name = userInput.nextLine();
        // using nextLIne will always work

        String greeting = "hello " + name;

        System.out.println(greeting);

    }
}
