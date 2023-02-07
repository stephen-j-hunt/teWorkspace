package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        wordSearch.run();
    }

    public void run() {
        /* Your code goes here */
        try (userInput) {
            System.out.println("What file would you like to search for?");
            final String filePath = userInput.nextLine();
            File textFile = new File(filePath);

            System.out.println("What word are you searching for?");
            String searchedWord = userInput.nextLine();

            System.out.println("Is the search case sensitive? y/n");
            String caseSense = userInput.nextLine();
            boolean isSensitive = false;

            if (caseSense.equalsIgnoreCase("y")) {
                isSensitive = true;
            }
            int counter = 1;

            try (Scanner fileInput = new Scanner(textFile)) {
                while (fileInput.hasNextLine()) {
                    String lineOfText = fileInput.nextLine();
                    if (!isSensitive) {
                        if (lineOfText.toLowerCase().contains(searchedWord.toLowerCase())) {
                            System.out.println(counter + ") " + lineOfText);
                        }
                    } else {
                        if (lineOfText.contains(searchedWord)) {
                            System.out.println(counter + ") " + lineOfText);
                        }
                    }
                    counter++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("that file does not exist");
        }

    }


}































