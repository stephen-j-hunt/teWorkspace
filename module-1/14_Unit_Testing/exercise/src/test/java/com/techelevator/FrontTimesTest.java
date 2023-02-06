package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrontTimesTest {

    @Test
public void ifStringIsThreeCopies() {
        FrontTimes result = new FrontTimes();
        assertEquals(result.generateString("Sox",3), "SoxSoxSox");
}
    @Test
    public void ifStringIsTwoCopies() {
        FrontTimes result = new FrontTimes();
        assertEquals(result.generateString("Sox",2), "SoxSox");
    }
    @Test
    public void ifStringIsOneCopies() {
        FrontTimes result = new FrontTimes();
        assertEquals(result.generateString("Sox",1), "Sox");
    }
}
