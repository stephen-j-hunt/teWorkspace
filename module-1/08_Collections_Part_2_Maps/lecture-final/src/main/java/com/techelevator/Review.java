package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;

public class Review {
    public static void main(String[] args) {

        /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates,
	    and then divide the total number of rooms to be painted by the combined rate.
	    */
        double billsRate = 1 / 2.15;
        double jillsRate = 1 / 1.9;
        double combinedRate = billsRate + jillsRate;
        int totalNumberOfRoomToPaint = 5;
        double totalTime = totalNumberOfRoomToPaint / combinedRate;

        /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
        int milesBetweencities = 800;
        int milesAlreadyTravelled = 537;
        double portionCompleted = milesAlreadyTravelled / (milesBetweencities * 1.0);
        int percentCompleted = (int) (portionCompleted * 100);

        /**
         * Is there a way to combine multiple OR conditionals such as
         * if (char == ‘M’ || ‘W’ || ‘F’) {
         * return value;
         * }
         *
         * if (c == 'M' || c == 'W' || c == 'F')
         */


        // dec2bin
        String input = "2 4 409";
        String[] values = input.split(" ");
        for (String value : values) {
            int decValue = Integer.parseInt(value);
            String result = "";
            while (decValue > 0) {
                result = decValue % 2 + result;
                decValue /= 2;
            }
            // System.out.print(String.format("%s => %s\n", value, result));
            System.out.printf("%s => %s\n", value, result);
        }

        // fib
        int limit = 10;
        System.out.print("0,1");
        int a = 0;
        int b = 1;
        int next = 0;
        while (a + b < limit) {
            next = a + b;
            System.out.print("," + next);
            a = b;
            b = next;
        }


    }

    /*
     Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with
     "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0. Note: use .equals()
     to compare 2 strings.
     hasBad("badxx") → true
     hasBad("xbadxx") → true
     hasBad("xxbadxx") → false
     */
    public static boolean hasBad(String str) {
        if (str.length() < 3) {
            return false;
        }
        return str.startsWith("bad") || str.substring(1).startsWith("bad");

    }

    /*
    The warehouse is out of small shirts and will only request more when the
    next order comes in that includes an 'S' shirt.

    Implement the logic to look through the next incoming order `char[] order`
    and return true if we need to place an order for Small shirts.

    Examples:
    placeRequest(['M', 'L', 'S']) → true
    placeRequest(['M', 'S', 'L']) → true
    placeRequest(['M', 'M', 'L']) → false
    placeRequest([]) → false
     */
    private final static char SMALL_TSHIRT = 'S';
    public static boolean placeRequest(char[] orders) {

        for (char order : orders) {
            if (order == SMALL_TSHIRT) {
                return true;
            }
        }
        return false;
    }

}
