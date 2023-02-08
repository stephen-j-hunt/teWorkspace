package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FizzWriter fizzWriter = new FizzWriter();
        fizzWriter.run();
    }

    public void run() {
        /* Your code goes here */
        try (userInput) {

            System.out.println("PLease enter a file name?");
            final String input = userInput.nextLine();
            final File destination = new File(input);

            try (PrintWriter dataOutput = new PrintWriter(destination)) {
                for (int i = 1; i <= 300; i++) {
                    if (i % 3 == 0 && i % 5 == 0) {
                        dataOutput.println("FizzBuzz");
                    }
                   else if (i % 3 == 0) {
                        dataOutput.println("Fizz");
                    }
                   else if (i % 5 == 0) {
                        dataOutput.println("Buzz");
                    } else {
                        dataOutput.println(i);
                    }

                }

            } catch (FileNotFoundException e) {
                System.out.println("File does not exist");
            }
        }
    }
}




