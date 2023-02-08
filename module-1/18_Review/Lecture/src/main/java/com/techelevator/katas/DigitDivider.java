package com.techelevator.katas;

import java.util.HashSet;
import java.util.Set;

public class DigitDivider {

    /**
     * Given a positive integer num, count the number of digits in num that
     * evenly divide into num. For example:
     *      The number 12 contains the digits [1,2].
     *      12 is evenly divisible by 1 since 12/1 = 12.
     *      12 is evenly divisible by 2 since 12/2 = 6.
     *      so countDividers(12) => 2
     *
     * @param num the number to evaluate
     * @return the number of digits in num that evenly divide num
     */
    public int countDividers(int num) {
//Make a set so that only unique digits are saved.
        Set<Integer> uniqueDigits = new HashSet<>();
        int modNum = num;
        while (modNum != 0) {
            int digit = modNum % 10;
            uniqueDigits.add(digit);
            modNum /= 10;
        }
        //Counter for valid divisors
        int validDivisorCount = 0;
        //Iterate through each unique digit divisor and increment the validDivisorCount if can divide the num by the value
        //without a remainder
        for (Integer digit : uniqueDigits) {
            if (num % digit == 0) validDivisorCount++;
        }
        return validDivisorCount;
    }
}
