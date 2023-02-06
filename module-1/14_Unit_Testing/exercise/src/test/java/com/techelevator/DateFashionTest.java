package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateFashionTest {

    @Test
    public void onePersonStyleIsOverEight() {
        DateFashion style = new DateFashion();
        final int tableYes = 2;
        final int tableMaybe = 1;
        final int tableNo = 0;
        Assert.assertEquals(2, style.getATable(8, 5));
    }

    @Test
    public void bothPersonStyleIsOverEight() {
        DateFashion style = new DateFashion();
        final int tableYes = 2;
        final int tableMaybe = 1;
        final int tableNo = 0;
        Assert.assertEquals(2, style.getATable(8, 8));
    }

    @Test
    public void bothPersonStyleIsUnderEight() {
        DateFashion style = new DateFashion();
        final int tableYes = 2;
        final int tableMaybe = 1;
        final int tableNo = 0;
        Assert.assertEquals(1, style.getATable(3, 3));
    }
    @Test
    public void bothPersonStyleIsUnderTwo() {
        DateFashion style = new DateFashion();
        final int tableYes = 2;
        final int tableMaybe = 1;
        final int tableNo = 0;
        Assert.assertEquals(0, style.getATable(1, 1));
    }
    @Test
    public void bothPersonStyleIsTwo() {
        DateFashion style = new DateFashion();
        final int tableYes = 2;
        final int tableMaybe = 1;
        final int tableNo = 0;
        Assert.assertEquals(0, style.getATable(2, 2));
    }
    @Test
    public void bothPersonStyleIsAboveEight() {
        DateFashion style = new DateFashion();
        final int tableYes = 2;
        final int tableMaybe = 1;
        final int tableNo = 0;
        Assert.assertEquals(2, style.getATable(10, 10));
    }
}
