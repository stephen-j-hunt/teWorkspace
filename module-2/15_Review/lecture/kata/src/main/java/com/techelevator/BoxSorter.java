package com.techelevator;

public class BoxSorter {
    /**
     * You are given an array of boxes (Box Objects as shown above). Use the 'sortByVolume()' method to sort the array by box volume
     * eiter in Ascending or Descending order and return the sorted array.
     *
     * Feel free to add any methods or properties the Box class if you feel you need them
     * (just don't remove what is there as the unit tests need it)
     *
     * Note1: If two boxes have the same volume, they have to be in the same order in the sorted output array
     *
     * For example if you have the following input array:
     *
     *      Box-1 - vol 400
     *      Box-5 - vol 100
     *      Box-2 - vol 200
     *      Box-3 - vol 200
     *      Box-4 - vol 200
     *
     * and you sort them in Ascending order, the result should be:
     *
     *      Box-5 - vol 100
     *      Box-2 - vol 200
     *      Box-3 - vol 200
     *      Box-4 - vol 200
     *      Box-1 - vol 400
     *
     * Notice the order of Box-2,3 and 4 is the same as the input
     *
     * Note2: Make sure you handle edge cases where sortByVolume is called with invalid parameters
     *
     */
    public enum SortOrder {
        ASC, DESC
    }

    public Box[] sortByVolume(Box[] input, SortOrder order) {
        // your code goes here
        return null;
    }
}
