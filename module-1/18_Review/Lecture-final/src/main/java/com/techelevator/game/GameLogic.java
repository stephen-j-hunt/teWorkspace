package com.techelevator.game;

public class GameLogic {

    public enum Result {
        EQUAL,
        LARGER,
        SMALLER
    }

    private int secret = 0;

    public GameLogic(int max) {
        this.secret = (int)(Math.random() * max-1)+1;
    }

    public Result evaluateGuess(int guess) {
        Result result = Result.EQUAL;
        if (guess > secret) { // game logic
            result = Result.LARGER;
        } else if (guess < secret) { // game logic
            result = Result.SMALLER;
        }
        return result;
    }

}
