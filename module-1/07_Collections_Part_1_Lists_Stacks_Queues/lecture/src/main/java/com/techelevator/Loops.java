package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loops {
    public static void main(String[] args) {
        int counter = 0;
        while (counter <10) {
            System.out.println(counter);//logic is scattered
            counter++;
        }
        System.out.println("=========");
        List<Integer> nums = new ArrayList<>(Arrays.asList(2,4,6,8,10,12));

        for(int i=0;i<nums.size();i++) {
            System.out.println(nums.get(i));//logic all on one line


            System.out.println("=========");
            //for each loop
            //for each item in the list do something
            for(Integer theNum : nums) {
                System.out.println(theNum);
            }

        }
    }
}
