package com.techelevator.game;

import java.util.Scanner;

public class Guess {

    public static void main(String[] args) {

        final int MAX_VALUE = 100;

        final UserInterface ui = new UserInterface();
        final GameLogic logic = new GameLogic(MAX_VALUE);


        while (true) { // game flow
            ui.sayGuessPrompt(1, MAX_VALUE);
            final int guess = ui.getGuess();
            final GameLogic.Result result = logic.evaluateGuess(guess);

            if (result == GameLogic.Result.EQUAL) { // game logic
                ui.prompt("CORRECT!");
                break; // game flow
            } else if (result == GameLogic.Result.LARGER) { // game logic
                ui.prompt("lower");
            } else { // game logic
                ui.prompt("higher");
            }

        }

    }

}
