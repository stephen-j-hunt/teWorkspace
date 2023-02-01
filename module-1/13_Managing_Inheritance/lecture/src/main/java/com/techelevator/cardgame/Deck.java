package com.techelevator.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    public Deck() {
        final int[] suites = {Card.SPADES, Card.CLUBS, Card.DIAMONDS, Card.HEARTS};
        final int[] ranks = {Card.ACE, Card.TWO, Card.THREE, Card.FOUR, Card.FIVE, Card.SIX,
        Card.SEVEN, Card.EIGHT, Card.NINE, Card.TEN, Card.JACK, Card.QUEEN, Card.KING};

        for (int suite : suites) {
            for (int rank : ranks) {
                Card c = new Card(rank, suite, false);
                this.cards.add(c);
            }
        }
    }

    public List<Card> getDeck() {
        return this.cards;
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

}
