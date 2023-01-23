package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // read from keyboard

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        String discountAsString = scanner.nextLine(); // read discount from keyboard
        double discount = Double.parseDouble(discountAsString) / 100.0; // convert to number

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String priceInput = scanner.nextLine(); // read prices from keyboard
        String[] pricesAsString = priceInput.split(" "); // parse out the individual prices

        for(int i=0; i < pricesAsString.length; i++) { // iterate through each price
            double price = Double.parseDouble(pricesAsString[i]); // convert the string to double
            double discountedPriced = price * (1-discount); // apply discount
//            String output = price + " discounted to " * discountedPriced;
//            String output = String.format("$%5.2f discounted to $%5.2f", price, discountedPriced);
            System.out.printf("$%5.2f discounted to $%5.2f \n", price, discountedPriced); // write the result to the screen
        }

    }

}
