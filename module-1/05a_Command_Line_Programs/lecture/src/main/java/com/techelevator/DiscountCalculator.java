package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // read from the keyboard

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        String discountAsString = scanner.nextLine(); // read discount from keyboard
        double discount = Double.parseDouble(discountAsString) / 100.0; //convert to number

        //prompt the user for a series of prices
        System.out.println("please provide a series of prices (space separated): ");
        String priceInput = scanner.nextLine(); //read prices form keyboard
        String[] pricesAsString = priceInput.split(" "); //parse out the individual process

        for(int i = 0; i < pricesAsString.length; i++) { // iterate through each price
            double price = Double.parseDouble(pricesAsString[i]); // convert string to a double
            double discountedPriced = price * (1-discount); // apply discount
            String output = String.format("$%5.2f", discountedPriced); //string.f and printf allow formatting of the output to the screen////link to codes in SLACK Class Formatter
            System.out.println(output); // write the result to screen
        }
    }

}
