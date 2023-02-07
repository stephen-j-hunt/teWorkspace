package com.techelevator.scanner;

import java.io.File;

public class ReverseFile {
    public static void main(String[] args) {
        ReverseFile rf =new ReverseFile();
        rf.run();
    }
    public void run() {

        File pwd = new File("");
        System.out.println(pwd.getAbsolutePath());

    }
}
