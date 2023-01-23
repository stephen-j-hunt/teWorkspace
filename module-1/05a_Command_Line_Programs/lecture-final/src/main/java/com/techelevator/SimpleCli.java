package com.techelevator;

import java.util.Scanner;

public class SimpleCli {
    public static void main(String[] args) {
        final Scanner userInput = new Scanner(System.in);

        // prompt the user for their name
        System.out.println("what is your name?");

        // read the name from the keyboard
        String name = userInput.nextLine();

        String greeting = "hello " + name;

        System.out.println(greeting);

    }
}
