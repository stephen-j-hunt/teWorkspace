package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class TemperatureTests {

    @Test
    public void single_value_returns_value() {
        // arrange
        final int expected = 55;
        final int[] temps = {expected};
        final Temperature tempTester = new Temperature();

        // act
        final int actual = tempTester.hottestDay(temps);

        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void multiple_value_returns_largest() {
        // arrange
        final int expected = 55;
        final int[] temps = {22, expected};
        final Temperature tempTester = new Temperature();

        // act
        final int actual = tempTester.hottestDay(temps);

        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void multiple_values_below_zero() {
        // arrange
        final int expected = -1;
        final int[] temps = {-10, -3, expected};
        final Temperature tempTester = new Temperature();

        // act
        final int actual = tempTester.hottestDay(temps);

        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void no_values() {
        // arrange
        final int[] temps = {};
        final Temperature tempTester = new Temperature();

        // act
        final int actual = tempTester.hottestDay(temps);

        // assert
        Assert.assertEquals(Integer.MIN_VALUE, actual);

//        Assert.assertEquals(5.0, 5.0, 0.01);
        
    }

}
