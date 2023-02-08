package com.techelevator.katas;

import org.junit.Assert;
import org.junit.Test;

public class DigitDividerTests {

    private DigitDivider sut = new DigitDivider();

    @Test
    public void works_for_6() {
        Assert.assertEquals("6 divides itself",1,sut.countDividers(6));
    }

    @Test
    public void nothing_for_23() {
        Assert.assertEquals("[2,3] do not divide 23",0,sut.countDividers(23));
    }

    @Test
    public void works_for_12() {
        Assert.assertEquals("both [1,2] divides 12",2,sut.countDividers(12));
    }

    @Test
    public void one_for_26() {
        Assert.assertEquals("of [2,6], 2 works for 26",1,sut.countDividers(26));
    }

    @Test
    public void another_all() {
        Assert.assertEquals("all of [1,2,4,8] divide 1248",4,sut.countDividers(1248));
    }


}
