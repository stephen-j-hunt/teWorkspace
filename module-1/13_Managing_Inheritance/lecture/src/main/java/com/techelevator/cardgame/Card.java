package com.techelevator.cardgame;

import java.util.HashMap;
import java.util.Map;

public class Card {

    public static final int SPADES = 1;
    public static final int DIAMONDS = 2;
    public static final int CLUBS = 3;
    public static final int HEARTS = 4;

    public static final int SNAKE_CASE = 0;

    public static final int ACE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    // the state of my object
    private Rank rank;
    private Suite suite;
    private boolean faceDown = true;

    public Card(Rank rank,Suite suite) {
        this.rank = rank;
        this.suite = suite;
        this.faceDown = false;
    }

    public Card(Rank rank, Suite suite, boolean faceDown) {
        this(rank, suite);
        this.faceDown = faceDown;
    }

    // a getter for the rank attribute
    public int getRank() {
        return this.rank;
    }

//    public void setRank(int rank) {
//        this.rank = rank;
//    }

    public int getSuite() {
        return this.suite;
    }

    // this is not complete
    public String getSuiteName() {
        if (this.suite == SPADES) {
            return "Spades";
        }
        return "Clubs";
    }

//    public void setSuite(int suite) {
//        this.suite = suite;
//    }

    public boolean isFaceDown() {
        return this.faceDown;
    }

    public void flip() {
        this.faceDown = !this.faceDown;
    }

    public String getCardName() {
        //final String[] cardNames = {"Spades", "Diamonds", "Clubs", "Hearts"};
        final Map<Integer, String> names = Map.of(SPADES, "Spades", DIAMONDS, "Diamonds", CLUBS, "Clubs", HEARTS, "Hearts");
        String name="";
        if (this.isFaceDown()) {
            name = "##########";
        } else {
            name = String.format("%s of %s", this.rank, names.get(this.suite));
        }
        return name;
    }
}
