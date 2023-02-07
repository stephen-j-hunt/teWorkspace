package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class FileInfo {
    public static void main(String[] args) {
        final Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the name of a file or folder");
        final String path = userInput.nextLine();

        final File f = new File(path);
        if (f.exists()) {
            System.out.printf("name: %s\n", f.getName());
            System.out.printf("path: %s\n", f.getAbsolutePath());
            if (f.isFile()) {
                System.out.println("is a file");
                System.out.println("size: %s\n", f.length());
            }

        }else{
            System.out.printf("%s does not exist \n",path);

    }
}

}
