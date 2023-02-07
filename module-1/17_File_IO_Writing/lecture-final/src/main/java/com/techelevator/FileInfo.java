package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class FileInfo {
    public static void main(String[] args) {
//        final Scanner userInput = new Scanner(System.in);
//        System.out.println("enter the name of a file or folder");
//        final String path = userInput.nextLine();

        String path = args[0]; // might be coming from the run configuration

        final File f = new File(path);
        if (f.exists()) {

            System.out.printf("name: %s\n", f.getName());
            System.out.printf("path: %s\n", f.getAbsolutePath());
            if (f.isFile()) {
                System.out.println("is a file");
                System.out.printf("size: %s\n", f.length());
                System.out.printf("can read? %s\n", f.canRead() );
                System.out.printf("can write? %s\n", f.canWrite());
                System.out.printf("can execute? %s\n", f.canExecute()); //WTF???
            } else {
                System.out.println("is a folder\n");
            }

        } else {
            System.out.printf("%s does not exist\n", path);
        }


    }
}
