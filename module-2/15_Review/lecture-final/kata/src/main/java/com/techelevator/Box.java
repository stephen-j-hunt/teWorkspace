package com.techelevator;

public class Box {
    public Box(int height, int width, int length, String name) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.name = name;
    }

    private int height;
    private int width;
    private int length;
    private String name;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Box{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", name='" + name + '\'' +
                '}';
    }
}
