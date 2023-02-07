package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class CreateFolder {
    public static void main(String[] args) {
        final Scanner userInput = new Scanner(System.in);
        System.out.println("what is the name of the folder to create?");
        final String folderName = userInput.nextLine();

        final File f = new File(folderName);
        if (f.exists()) {
            System.out.println("something with that name already exists");
        } else {
            if ( f.mkdir()) {
                System.out.println("folder created");
                System.out.printf("@ %s", f.getAbsolutePath());
            } else {
                System.out.println("sorry, not gonna happen");
            }
        }
    }
}
