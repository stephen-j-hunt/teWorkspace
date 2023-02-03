package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AlarmClockTest {

    @Test
    public void when_sunday_and_on_vacation_should_be_off() {
        //arrange

        final int sunday = 0;
        final boolean onVacation = true;
        final AlarmClock clock = new AlarmClock();

        //act
        String result = clock.wakeUp(sunday, onVacation);

        //assert
        Assert.assertEquals("should be off", "off", result);

    }
    @Test
public void when_sunday_and_not_vacation_should_be_off_10() {
        //arrange
    final int sunday = 0;
    final boolean notVacation = false;
    final AlarmClock clock = new AlarmClock();

    //act
    String result = clock.wakeUp(sunday, notVacation);

    //assert
    //Assert.assertTrue("should be 10am", AlarmClock. result);


}

}
