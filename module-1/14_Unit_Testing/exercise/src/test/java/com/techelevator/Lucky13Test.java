package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Lucky13Test {

    @Test
    public void ifArrayHasNeitherInIt() {
        Lucky13 lucky = new Lucky13();
        final int[] result = {2, 5, 8};
        assertTrue(lucky.getLucky(result));
    }
@Test
    public void ifArrayHasOneInIt() {
        Lucky13 lucky = new Lucky13();
        final int[] result = {1, 5, 8};
        assertFalse(lucky.getLucky(result));
    }
@Test
    public void ifArrayHasThreeInIt() {
        Lucky13 lucky = new Lucky13();
        final int[] result = {3, 5, 8};

        assertFalse(lucky.getLucky(result));
    }
    @Test
    public void ifArrayHasOneAndThreeInIt() {
        Lucky13 lucky = new Lucky13();
        final int[] result = {1, 5, 3};
        assertFalse(lucky.getLucky(result));
    }

}
