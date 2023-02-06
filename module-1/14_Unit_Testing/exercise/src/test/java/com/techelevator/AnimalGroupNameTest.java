package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AnimalGroupNameTest {

    @Test
    public void deerShouldReturnHerd() {
        AnimalGroupName animals;
        animals = new AnimalGroupName();
        Assert.assertEquals(animals.getHerd("deer"), "Herd");
    }
    @Test
    public void DOGShouldReturnPack() {
        AnimalGroupName animals;
        animals = new AnimalGroupName();
        Assert.assertEquals(animals.getHerd("DOG"), "Pack");
    }
    @Test
    public void RhiNoShouldReturnCrash() {
        AnimalGroupName animals;
        animals = new AnimalGroupName();
        Assert.assertEquals(animals.getHerd("RhInO"), "Crash");
    }
    @Test
    public void CatShouldReturnUnknown() {
        AnimalGroupName animals;
        animals = new AnimalGroupName();
        Assert.assertEquals(animals.getHerd("cat"), "unknown");
    }
    @Test
    public void noAnimalNameShouldReturnUnknown() {
        AnimalGroupName animals;
        animals = new AnimalGroupName();
        Assert.assertEquals(animals.getHerd(""), "unknown");
    }

    @Test
    public void nullAnimalNameShouldReturnUnknown() {
        AnimalGroupName animals;
        animals = new AnimalGroupName();
        Assert.assertEquals(animals.getHerd("null"), "unknown");
    }
}

