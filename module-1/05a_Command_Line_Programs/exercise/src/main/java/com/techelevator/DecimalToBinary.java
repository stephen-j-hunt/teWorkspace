package com.techelevator;

import java.net.UnknownServiceException;
import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter in a series of decimal values (separated by spaces):");
        String input = scanner.nextLine();
        String[] spaces = input.split(" ");

        for (int i = 0; i < spaces.length; i++) {
            int userInput = Integer.parseInt(spaces[i]);
            String userInput2 = "";
            while (userInput > 0) {
                userInput2 = (userInput % 2) + userInput2;
                userInput /= 2;
            }
            System.out.println(spaces[i] + " in binary is " + userInput2);

        }


        //	cumulativeString = cumulativeString + newDigit; // appends newDigit (adds it to the end)
        //cumulativeString = newDigit + cumulativeString; // prepends newDigit (adds it to the beginning)
    }

}
