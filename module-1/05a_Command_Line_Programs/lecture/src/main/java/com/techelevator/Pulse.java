package com.techelevator;
///////////////// index out of bounds concerns//////////////
public class Pulse {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(nums [0]); // smallest legal index
        System.out.println(nums [3]); // largest legal index
      //  System.out.println(nums [4]); // wont work

        for (int i =0;i <= nums.length; i++) { // this will go 1 past the number in array we have to index 4 we only have 3
            int x = nums[i];
        }
    }
}
