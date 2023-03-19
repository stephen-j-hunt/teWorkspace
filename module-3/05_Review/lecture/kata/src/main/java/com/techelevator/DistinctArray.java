package com.techelevator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DistinctArray {
    /**
     * You are given an input array of integers. Write a function to remove any duplicate
     * numbers from the input array
     *
     *  for example, given array:
     *
     *  [2, 3, 1, 8, 4, 8, 5, 1, 9, 8, 6]
     *
     *  the function returns:
     *
     *  [2, 3, 1, 8, 4, 5, 9, 6]
     *
     *  Provide 2 implementations for this function:
     *      A) - The unique numbers in the returned array can be in ANY order
     *      (easier case).
     *      Implement inside removeDuplicates() function below.
     *
     *      B) - The unique numbers in the returned array must be in the SAME
     *      order as the input array (see example above).
     *      Implement inside removeDuplicatesPreserveOrder() function below.
     *
     *      NOTE: This kata is similar to a problem that you may get as a part of an interview assessment.
     *      To keep this exercise realistic, PLEASE DON'T SEARCH THE WEB FOR A COMPLETE SOLUTION TO
     *      REMOVING DUPLICATES FROM AN ARRAY.
     *
     */

    public int[] removeDuplicates(int[] input) {
        if(input == null) {
            return input;
        }
        Set<Integer> intSet = new HashSet<>();
        for(int i =0; i < input.length; i++) {
            intSet.add(input[i]);
        }

        int[] arr = new int[intSet.size()];
        int count = 0;
        for(Integer num : intSet) {
            arr[count] = num;
            count++;
        }

        return arr;
//        List<Integer> intList = new ArrayList<>();
//        for (int i =0; i < input.length; i++) {
//            if(intList.contains(input[i])){
//                continue;
//            } else {
//                intList.add(input[i]);
//            }
//        }
//        int[] intArr = new int[intList.size()];
//        int count = 0;
//        for(Integer num : intList) {
//            intArr[count] = num;
//            count++;
//        }
//        return intArr;




    }







    public int[] removeDuplicatesPreserveOrder(int[] input) {

        if(input == null) {
            return input;
        }
        List<Integer> intList = new ArrayList<>();
        for (int i =0; i < input.length; i++) {
            if(intList.contains(input[i])){
                continue;
            } else {
                intList.add(input[i]);
            }
        }
        int[] intArr = new int[intList.size()];
        int count = 0;
        for(Integer num : intList) {
            intArr[count] = num;
            count++;
        }
        return intArr;

    }

    }
}
