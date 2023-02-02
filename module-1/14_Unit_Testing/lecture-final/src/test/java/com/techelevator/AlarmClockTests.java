package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlarmClockTests {

    private AlarmClock clock;

    @Before
    public void setup() {
        System.out.println("in setup");
        // pretending that creating a clock is a lot of work
        clock = new AlarmClock();
    }

    @After
    public void cleanup() {
        System.out.println("in cleanup");
        clock = null;
    }

    @Test
    public void when_sunday_and_on_vacation_should_be_off() {
        System.out.println("in the test");
        // arrange
        final int sunday = 0;
        final boolean onVacation = true;

        executeSut(sunday, onVacation, AlarmClock.OFF);
    }

    @Test
    public void when_sunday_and_not_vacation_should_be_10() {
        // arrange
        final int sunday = 0;
        final boolean notVacation = false;

        executeSut(sunday, notVacation, AlarmClock.TEN_AM);
    }

    @Test
    public void when_monday_and_not_vacation_should_be_7() {
        // arrange
        final int monday = 1;
        final boolean notVacation = false;

        executeSut(monday, notVacation, AlarmClock.SEVEN_AM);
    }

    @Test
    public void when_monday_and_on_vacation_should_be_10() {
        // arrange
        final int monday = 1;
        final boolean onVacation = true;

        // act
        executeSut(monday, onVacation, AlarmClock.TEN_AM);
    }

    private void executeSut(int dayOfWeek, boolean isOnVacation, String expected) {
        // act
        String result = clock.wakeUp(dayOfWeek, isOnVacation);

        // assert
        Assert.assertEquals("should be " + expected, expected, result);

    }

}
