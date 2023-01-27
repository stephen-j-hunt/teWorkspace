package com.techelevator;

public class Pulse {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6};

        for(int i=0; i<nums.length; i++) {
            int value = nums[i];
            System.out.println(value);
        }

        // for each value in nums
        for(int value: nums) {
            System.out.println(value);
        }




    }
}
