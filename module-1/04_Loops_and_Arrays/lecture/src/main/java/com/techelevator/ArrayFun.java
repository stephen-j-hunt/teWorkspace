package com.techelevator;

public class ArrayFun {
    public static void main(String[] args) {

        int a = 5;
        int b = 2;

        int[] scores;
        scores = new int[18];
        int[] scores2 = new int[18];
        scores2[0] = 0;
        scores2[1] = 1;
        scores2[2] = 2;
        System.out.println(scores2[0]);
        System.out.println(scores2[1]);
        int[] nums = new int[] {1,2,3,4};  //array of 4 ints with values
        System.out.println(nums[0]);
        System.out.println(nums[3]);


        int[] num2 = {1,2,3,4};  //array of 4 ints with values
        System.out.println("num2 has a length of " + num2.length);
        int [] num3 = num2;
        System.out.println(num3[2]);

        System.out.println(num2[0]);
        System.out.println(num3[0]);
        num3 [0] = 42;
        System.out.println(num3[0]);
        System.out.println(num2[0]);

        zeroFirstElement(num2);
        System.out.println(num3[0]);
        System.out.println(num2[0]);


    }

    private static void zeroFirstElement(int[] arr) {
        arr[0] = 0;
    }
}
