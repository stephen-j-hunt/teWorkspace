package com.techelevator.paint;

public class RectWall extends Wall{

    private final int length;
    private final int height;

    public RectWall(String name, String color, int length, int height) {
        super(name, color);
        this.length = length;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getArea() {
        return this.length * this.height;
    }

    @Override
    public String toString() {
        return String.format("%s (%dx%d) rect", this.getName(), this.length, this.height);
    }
}
