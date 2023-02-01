package com.techelevator.cardgame;

public class Card {

    public enum Orientation {
        FACEUP,
        FACEDOWN,
    }

    // the state of my object
    private Rank rank;
    private Suite suite;
    private Orientation orientation = Orientation.FACEDOWN;

    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
        this.orientation = Orientation.FACEDOWN;
    }

    public Card(Rank rank, Suite suite, Orientation orientation) {
        this(rank, suite);
        this.orientation = orientation;
    }

    // a getter for the rank attribute
    public Rank getRank() {
        return this.rank;
    }

    public Suite getSuite() {
        return this.suite;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public void flip() {
        this.orientation = (this.orientation == Orientation.FACEDOWN)
                ? Orientation.FACEUP
                : Orientation.FACEDOWN;
    }


    @Override
    public String toString() {
        String name="";
        if (getOrientation() == Orientation.FACEDOWN) {
            name = "##########";
        } else {
            name = String.format("%s of %s", this.rank, this.suite);
        }
        return name;
    }
}
