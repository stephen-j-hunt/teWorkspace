package com.techelevator;

public class Methods {
    public static void main(String[] args) {
        System.out.println("calling add");
        int result = add(2, 3);
        System.out.println(result);
    }



    public static int add(int a, int b) {
        System.out.println("before return");
        return a + b;

    }
}
