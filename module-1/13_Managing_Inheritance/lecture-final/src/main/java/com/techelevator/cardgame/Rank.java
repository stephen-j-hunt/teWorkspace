package com.techelevator.cardgame;

public enum Rank {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private final int ord;

    public int getOrd() {
        return this.ord;
    }

    Rank(int ord) {
        this.ord = ord;
    }
}
