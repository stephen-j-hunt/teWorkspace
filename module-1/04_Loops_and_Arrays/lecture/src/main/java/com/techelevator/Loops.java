package com.techelevator;

// calculate this factorial
// 4! = 4*3*2*1 = 24
public class Loops {
    public static void main(String[] args) {

        System.out.println(FactOfFour());
        System.out.println();
        System.out.println(FactOfFour());
        System.out.println(sumOfOdds(5));
    }

    private static int sumOfOdds(int n) {
        int result = 0;
        for (int number = 1; number <= n; number += 2){
            result += number;
        }
        return result;
    }


    private static int FactOfFour() {
        return 4 * 3 * 2 * 1;
    }
}

//
//        result=1;
//                // initial condition increment
//                for(int c=1;c<=n;c++)
//                {
//
//                result*=c;
//                }
