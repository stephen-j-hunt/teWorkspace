package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DriverTest {

    @Test
    public void has_permit_with_licensed_driver() {
        //arrange
        final boolean permit = true;
        final boolean licensedDriver = true;
        final Driver driver =new Driver();
        //act
        boolean result = driver.canDrive(permit, licensedDriver);

        //assert
        Assert.assertTrue("should be allowed to drive",result);
    }




}
