package com.techelevator.cardgame;

public class Table {
    public static void main(String[] args) {

        Deck myDeck = new Deck();
        myDeck.shuffle();
        for (Card theCard : myDeck.getDeck()) {
            System.out.println(theCard);
        }

    }
}
