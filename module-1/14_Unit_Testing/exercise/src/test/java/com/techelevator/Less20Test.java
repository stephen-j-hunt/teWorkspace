package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Less20Test {

@Test
    public void  oneLessThan20() {
    Less20 result= new Less20();
assertTrue(result.isLessThanMultipleOf20(19));
}
    @Test
    public void  twoLessThan20() {
        Less20 result= new Less20();
        assertTrue(result.isLessThanMultipleOf20(18));
    }
    @Test
    public void  isEqualTo20() {
        Less20 result= new Less20();
        assertFalse(result.isLessThanMultipleOf20(20));
    }

}


