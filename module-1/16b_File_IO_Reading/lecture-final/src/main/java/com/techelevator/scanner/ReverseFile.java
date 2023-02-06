package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReverseFile {
    public static void main(String[] args) {
        ReverseFile rf = new ReverseFile();
        rf.run();
    }

    public void run() {

//        File pwd = new File(""); // current working directory
//        System.out.println(pwd.getAbsolutePath());

        final Scanner userInput = new Scanner(System.in);
        System.out.println("enter the full path of a file");
        final String filename = userInput.nextLine();

        final File sourceFile = new File(filename);
        if (!sourceFile.exists()) {
            System.out.println("file not found");
            return;
        }

        if (!sourceFile.isFile()) {
            System.out.println("not a file");
            return;
        }

        if (!sourceFile.canRead()) {
            System.out.println("access denied!");
            return;
        }


        try(Scanner fileReader = new Scanner(sourceFile);
            
        ) {
            while (fileReader.hasNextLine()) {
                final String lineOfText = fileReader.nextLine();
                final StringBuilder sb = new StringBuilder(lineOfText);
                System.out.println(sb.reverse().toString());
            }
        } catch (FileNotFoundException e) {
            // this is really silly.
            throw new IllegalArgumentException("file not found", e);
        }


//        Scanner fileReader=null;
//        try {
//            fileReader = new Scanner(sourceFile);
//            while (fileReader.hasNextLine()) {
//                final String lineOfText = fileReader.nextLine();
//                final StringBuilder sb = new StringBuilder(lineOfText);
//                System.out.println(sb.reverse().toString());
//            }
//        } catch (FileNotFoundException e) {
//            // this is really silly.
//            throw new IllegalArgumentException("file not found", e);
//        } finally {
//            if (fileReader != null) {
//                fileReader.close();
//            }
//        }



    }

}
