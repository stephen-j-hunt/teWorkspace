package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {

    @Test
    public void will_shift_left() {
        // arrange
        final int[] nums = {1,2,3};
        final int[] expected = {2,3,1};
        final ArrayUtils utils = new ArrayUtils();

        // act
        int[] actual = utils.rotateLeft3(nums);

        // assert
        Assert.assertArrayEquals("array was not shifted correctly", expected, actual);
    }

}
