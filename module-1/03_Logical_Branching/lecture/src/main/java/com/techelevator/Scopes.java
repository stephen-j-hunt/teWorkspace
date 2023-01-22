package com.techelevator;

public class Scopes {
    public static void main(String[] args) {

        int var = 0;
        System.out.println(var);

        {
            int y = 0;
            int x = 0;
            System.out.println(var);
            x = 4;
        }

        x = 8;
    }
}
