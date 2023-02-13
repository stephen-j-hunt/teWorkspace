package com.techelevator;

import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Questions {
    public static void main(String[] args) {
        String question1 = "what color is the sky?/1) blue/2) green/3) red/4) pink";
        String[] oneQuestion = question1.split("/");
        for (int i = 0; i < question1.length(); i++) {
            System.out.println(oneQuestion[i]);
        }
        System.out.println("Correct! You have answered   question correctly");
    }
    }


