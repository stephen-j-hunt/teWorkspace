package com.techelevator;

public class Loops {
    public static void main(String[] args) {

        for(int i=0; i<10; i++) {
//            if (i == 5) {
                //continue; // stop the current iteration and return to the top of the loop
//                break; // stop the current iteration and leaves the loop
//            }
                // 40 lines of code
                System.out.println("hello world");
        }

//        System.out.println(FactOfFour());
//        System.out.println(FactOfFive());
//        System.out.println(Fact(4));
//        System.out.println(SumOfOdds(5));
    }

    private static int SumOfOdds(int n) {

        // 1,3,5,7,9,....,n
        int result = 0;
        for(int number=1; number <= n; number += 2) {
            result += number;
        }
        return result;
    }


    private static int Fact(int n) {
        int result = 1;
        int counter = 1;  // init
//        while (counter <= n) {  // condition
//            result = result * counter;
//            counter++; // incrementing
//        }

        result = 1;
        //      init  condition  increment
        for(int c=1;  c <= n;    c++) {
            result *= c;
        }


        return result;
    }

    private static int FactOfFour() {
        return 4*3*2*1;
    }

    private static int FactOfFive() {
        return 5*4*3*2*1;
    }
}
