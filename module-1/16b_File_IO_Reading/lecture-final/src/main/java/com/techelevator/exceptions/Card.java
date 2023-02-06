package com.techelevator.exceptions;

public class Card {
    private int rank; // 1=Ace - 13=King

    public void setRank(int rank) {
        // parameter checking (defensive programming)
        if (rank < 1 || rank > 13) {
            throw new IllegalArgumentException("rank must be between 1 & 13");
        }

        this.rank = rank;
    }

}
