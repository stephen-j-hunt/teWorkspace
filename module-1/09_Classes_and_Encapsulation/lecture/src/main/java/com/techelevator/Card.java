package com.techelevator;

public class Card {
    public static final int SPADES = 1;
    public static final int DIAMONDS = 2;
    public static final int Clubs = 3;
    public static final int HEARTS = 4;



    // the state of my object
    private int rank;
    private int suite;
    private boolean faceDown = true;

    public Card(int rank, int suite, boolean faceDown) {
        this.rank = rank;
        this.suite  = suite;
        this.faceDown = faceDown;
    }

    //a getter for the rank attribute
    public int geRank() {
        return this.rank;
    }
    //public void setRank(int rank) {
      //  this.rank = rank;
    //}

    public int getSuite() {
        return this.rank;
    }
    public String getSuiteName() {
        if (this.suite == SPADES) {
            return "Spades";
        }
        return "Clubs";
    }

    public void setSuite(int suite) {
        this.suite = suite;
    }
    public boolean isFaceDown() {
        return this.faceDown;
    }
    public void flip() {
        this.faceDown = !this.faceDown;
    }
}
