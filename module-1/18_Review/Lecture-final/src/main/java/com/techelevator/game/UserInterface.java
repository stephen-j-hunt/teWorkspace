package com.techelevator.game;

import java.util.Scanner;

public class UserInterface {

    private Scanner userInput = new Scanner(System.in);

    public void prompt(String message) {
        System.out.println(message);
    }

    public void sayGuessPrompt(int min, int max) {
        prompt("pick a number between " + min + " & " + max);
    }

    public int getGuess() {
        final String str = userInput.nextLine();
        final int guess = Integer.parseInt(str);
        return guess;
    }

}
