package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class BoxSorterTest {

    BoxSorter sorter;

    Box[] getSomeRandomBoxes(int boxesToGet) {

        Box[] boxes = new Box[boxesToGet];

        for (int i = 0; i != boxesToGet; i++)
            boxes[i] = new Box(getRandomDimension(), getRandomDimension(), getRandomDimension(), "Box-" + (i + 1));

        return boxes;
    }

    boolean assertOrder(Box[] boxArray, boolean isAscending) {

        System.out.println("\nChecking the " + (isAscending ? "Ascending" : "Descenting") + " order for " + boxArray.length + " boxes...");

        for (int i = 0; i != boxArray.length; i++) {
            System.out.println((i + 1) + ". " + boxArray[i] + " Volume: " + getBoxVolume(boxArray[i]));
            if(i == 0) continue;
            int diff = getBoxVolume(boxArray[i-1]) - getBoxVolume(boxArray[i]);
            if ((diff < 0 && !isAscending) || (diff > 0 && isAscending))
                return false;
        }

        return true;
    }

    int getRandomDimension() {
        return new Random().nextInt(46) + 5;
    }

    int getBoxVolume(Box box) {
        return box.getHeight() * box.getLength() * box.getWidth();
    }

    @Before
    public void setup() {
        sorter = new BoxSorter();
    }

    @Test
    public void testSort_Ascending_works_correctly() {
        Box[] random = getSomeRandomBoxes(20);

        Box[] sorted = sorter.sortByVolume(random, BoxSorter.SortOrder.DESC);
        Assert.assertTrue("Boxes are Sorted in Ascending Order", assertOrder(sorted, false));
    }

    @Test
    public void testSort_Descending_works_correctly() {
        Box[] random = getSomeRandomBoxes(15);

        Box[] sorted = sorter.sortByVolume(random, BoxSorter.SortOrder.ASC);
        Assert.assertTrue("Boxes are Sorted in Ascending Order", assertOrder(sorted, true));
    }

    @Test
    public void testSort_Same_volume_Order_is_preserved() {
        Box[] same = new Box[] {
                new Box(20,20,30,"Box-2"),
                new Box(20,30,20,"Box-3"),
                new Box(30,20,20,"Box-4"),
                new Box(50,20,30,"Box-5"),
                new Box(10,20,30,"Box-1")
        };

        Box[] sorted = sorter.sortByVolume(same, BoxSorter.SortOrder.ASC);
        Assert.assertTrue("Boxes are Sorted in Ascending Order", assertOrder(sorted, true));
        Assert.assertEquals("Box-2 is in correct order", sorted[1].getName(), "Box-2");
        Assert.assertEquals("Box-3 is in correct order", sorted[2].getName(), "Box-3");
        Assert.assertEquals("Box-4 is in correct order", sorted[3].getName(), "Box-4");
    }

    @Test
    public void testSort_One_Box_works_correctly () {
        Box[] same = new Box[] {
                new Box(20,20,30,"Box-Alone"),
        };

        Box[] sorted = sorter.sortByVolume(same, BoxSorter.SortOrder.ASC);
        Assert.assertEquals("Box-Alon is still there", sorted[0].getName(), "Box-Alone");
    }

    @Test
    public void testNoBoxes_works_correctly () {
        Box[] same = new Box[0];

        Box[] sorted = sorter.sortByVolume(same, BoxSorter.SortOrder.ASC);
        Assert.assertNotNull("We still need the empty array", sorted);

        Box[] sortedNull = sorter.sortByVolume(null, BoxSorter.SortOrder.ASC);
        Assert.assertNull("We need a null array", sortedNull);
    }
}
