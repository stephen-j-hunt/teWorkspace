package com.techelevator;

public class Loops {
    public static void main(String[] args) {
//
//        for(int i=0; i<10; i++) {
////            if (i == 5) {
//                //continue; // stop the current iteration and return to the top of the loop
////                break; // stop the current iteration and leaves the loop
////            }
//                // 40 lines of code
//                System.out.println("hello world");
//        }

        loopsWhile();
//        forOptions();
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

    private static void loopsWhile() {
//        int[] nums = new int[] {1, 2, 3, 4, 5};
//        int i = 0;
//        while (i < nums.length) {
//            System.out.println(nums[i]);
//            i++;
//        }
        int bigNum = 80;
        String stuff = "hello";
        String blank = "";
        int length = stuff.length();
        int i = 0;

        while (i < length) {


            blank = stuff.charAt(i) + blank;
//            blank = (i) + blank;
//            blank = blank + stuff.charAt(i);
            System.out.println(blank);
            i++;
        }
        while (bigNum > 0) {
            bigNum/=2;
            System.out.println(bigNum);
        }
    }

    private static void forOptions() {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        int someNum = 1;
        for(; someNum < nums.length; someNum++) {
            System.out.println(nums[someNum]);
        }
        int anotherNum = 0;
        for (int i = anotherNum; i < nums.length;) {
            System.out.println(nums[i]);
            i+=1;
        }
    }



    private static int FactOfFour() {
        return 4*3*2*1;
    }

    private static int FactOfFive() {
        return 5*4*3*2*1;
    }
}
