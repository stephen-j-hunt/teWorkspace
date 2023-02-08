package com.techelevator.katas;

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

        if (num == 0) {
            return 0;
        }

        int counter = 0;
        int burner = num;
        while (burner > 0) {
            int rem = burner % 10;
            if (num % rem == 0) {
                counter++;
            }
            burner /= 10;
        }

        return counter;
    }

}
