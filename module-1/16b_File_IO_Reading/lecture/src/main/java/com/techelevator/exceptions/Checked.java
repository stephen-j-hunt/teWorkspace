package com.techelevator.exceptions;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Checked {

    public void checked() {
        File f = new File("");
        try {
            Scanner scanner = new Scanner(f);
        } catch (FileNotFoundException fnf) {

        }
    }

    public void nonChecked() {
        Integer.parseInt("hello");
    }
}
