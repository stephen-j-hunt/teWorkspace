package com.techelevator;

public class SquareWall extends RectangleWall {
    private int sideLength;

    public SquareWall(String name, String color, int sideLength) {
        super(name, color);
        this.sideLength = sideLength;
    }
    public int getSideLength() {
        return sideLength;
    }
    public String toString() {
        return String.format("%s (%dx%d) square", getName(), getSideLength(), getSideLength());
    }
    @Override
    public int getArea() {
        return sideLength*sideLength;
    }
}
