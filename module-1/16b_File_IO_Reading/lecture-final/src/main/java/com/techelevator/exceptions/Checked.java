package com.techelevator.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Checked {

    public void checked() {
        File f = new File("");
        try {
            Scanner scanner = new Scanner(f);
        } catch (FileNotFoundException fnf) {
            // do someting
        }
    }

    public void nonchecked() {
        // will throw a NumberFormatException but it's not
        // a checked exception
        Integer.parseInt("hello");
    }

}
