package com.techelevator.paint;

public class SquareWall extends RectWall {
    public SquareWall(String name, String color, int side) {
        super(name, color, side, side);
    }

    public int getSide() {
        return this.getLength();
    }

    @Override
    public String toString() {
        return super.toString().replace("rect", "square");
    }
}
