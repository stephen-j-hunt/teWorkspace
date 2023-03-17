package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DistinctArrayTest {

    DistinctArray distinct;
    private final Random generator = new Random(new Date().getTime());

    int[] getRandomRepeatingArray(int elementsToGet) {

        int[] randomReps = new int[elementsToGet];

        for (int i = 0; i != elementsToGet - 5; i++)
            randomReps[i] = getRandomNumber(20);

        for (int i = elementsToGet - 5; i != elementsToGet; i++)
            randomReps[i] = randomReps[getRandomNumber(i)];

        return randomReps;
    }

    void dumpArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    int getRandomNumber(int range) {
        return generator.nextInt(range);
    }

    boolean areEqual(int[] lhs, int[] rhs) {
        
        if (lhs == null && rhs == null)
            return true;

        if (lhs == null || rhs == null)
            return false;

        Set<Integer> lhsset = IntStream.of(lhs).boxed().collect(Collectors.toSet());
        Set<Integer> rhsset = IntStream.of(rhs).boxed().collect(Collectors.toSet());

        return  lhsset.equals(rhsset);
    }
    
    @Before
    public void setup() {
        distinct = new DistinctArray();
    }

    @Test
    public void testAnyOrder_works_correctly() {

        int[] input = getRandomRepeatingArray(20);
        int[] output = distinct.removeDuplicates(input);
        int[] noDuplicates = IntStream.of(input).distinct().toArray();

        final boolean areSame =  areEqual(output, noDuplicates);

        if(!areSame) {
            System.out.println("Input: " + Arrays.toString(input));
            System.out.println("Received: " + Arrays.toString(output));
            System.out.println("Expected: " + Arrays.toString(noDuplicates));
        }
        Assert.assertTrue("Array elements are not unique!", areSame );
    }

    @Test
    public void testPreserveOrder_works_correctly() {

        int[] input = getRandomRepeatingArray(20);
        int[] output = distinct.removeDuplicatesPreserveOrder(input);
        int[] noDuplicates = IntStream.of(input).distinct().toArray();

        final boolean areSame =  areEqual(output, noDuplicates);

        if(!areSame) {
            System.out.println("Input: " + Arrays.toString(input));
            System.out.println("Received: " + Arrays.toString(output));
            System.out.println("Expected: " + Arrays.toString(noDuplicates));
        }
        Assert.assertTrue("Array elements are not unique or not in the same order!", areSame );
    }

    @Test
    public void testNoElementsAnyOrder_works_correctly() {
        int[] empty = new int[0];
        int[] deDuped = distinct.removeDuplicates(empty);

        Assert.assertNotNull("We need an empty array", deDuped);
        Assert.assertTrue("We need an empty array", areEqual(empty,deDuped));
    }

    @Test
    public void testNullElementsAnyOrder_works_correctly() {

        int[] deDuped = distinct.removeDuplicates(null);
        Assert.assertNull("We need a null array", deDuped);
    }

    @Test
    public void testNoElementsPreserveOrder_works_correctly() {
        int[] empty = new int[0];

        int[] deDuped = distinct.removeDuplicatesPreserveOrder(empty);

        Assert.assertNotNull("We need an empty array", deDuped);
        Assert.assertTrue("We need an empty array", areEqual(empty,deDuped));
    }

    @Test
    public void testNullElementsPreserveOrder_works_correctly() {

        int[] deDuped = distinct.removeDuplicatesPreserveOrder(null);
        Assert.assertNull("We need a null array", deDuped);
    }
}