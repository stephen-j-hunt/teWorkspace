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
        scores2[3] = 2;
        System.out.println(scores2[0]);
        System.out.println(scores2[1]);

        System.out.println("<<<<<<<<<<<<<<<");
        int[] nums = new int[]{1,2,3,4}; // array of 4 ints with values
//        System.out.println(nums[0]);
//        System.out.println(nums[3]);

        // iterate from start to end
        for(int i=0; i<nums.length; i++) {
            System.out.println(nums[i]);
        }

        // iterate from end to start
        for(int i=nums.length-1; i>=0; i--) {
            System.out.println(nums[i]);
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        int[] num2 = {1,2,3,4}; // array of 4 ints with values
        System.out.println("num2 has a length of " + num2.length);
        int[] num3 = num2;
        System.out.println(num3[2]);

        System.out.println("================");
        System.out.println(num2[0]);
        System.out.println(num3[0]);

        num3[0] = 42;
        System.out.println(num3[0]);
        System.out.println(num2[0]);

        zeroFirstElement(num2);
        System.out.println(num3[0]); // ??
        System.out.println(num2[0]); // ???

        int[] nothing;
        nothing = new int[2];
        System.out.println(nothing.length);

    }

    private static int[] dupArray(int[] arr) {
        int[] dup = new int[arr.length];
        for(int i=0; i < arr.length; i++) {
            dup[i] = arr[i];
        }
        return dup;
    }

    private static void zeroFirstElement(int[] arr) {
        arr[0] = 0;
    }
}
