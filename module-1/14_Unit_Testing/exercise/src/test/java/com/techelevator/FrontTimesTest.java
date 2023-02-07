package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrontTimesTest {

    @Test
    public void ifStringIsThreeCopies() {
        FrontTimes result = new FrontTimes();
        assertEquals("SoxSoxSox", result.generateString("Sox", 3));
    }

    @Test
    public void ifStringIsTwoCopies() {
        FrontTimes result = new FrontTimes();
        assertEquals("SoxSox", result.generateString("Sox", 2));
    }

    @Test
    public void ifStringIsOneCopies() {
        FrontTimes result = new FrontTimes();
        assertEquals("Sox", result.generateString("Sox", 1));
    }

    @Test
    public void ifStringIsGreaterThanThree() {
        FrontTimes result = new FrontTimes();
        assertEquals("HelHelHelHel", result.generateString("Hello", 4));
    }
}
