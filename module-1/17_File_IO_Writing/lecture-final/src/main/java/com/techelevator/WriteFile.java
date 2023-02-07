package com.techelevator;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class WriteFile {
    public static void main(String[] args) {
        final Scanner userInput = new Scanner(System.in);
        System.out.println("what is the name of the file?");
        final String path = userInput.nextLine();

        final File f = new File(path);
        try (final FileOutputStream out = new FileOutputStream(f,true); // true means append to the file
             final PrintWriter writer = new PrintWriter(out);) {
            writer.printf("it is now %s\n", LocalDateTime.now());
        } catch (IOException e) {
            System.out.println("sorry, cannot write to the file");
        }
    }
}
