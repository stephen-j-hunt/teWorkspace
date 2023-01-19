package com.techelevator;

public class Methods {
    public static void main(String[] args) {
        System.out.println("calling add"); // 1
        int result = add(2, 3); // 2
        System.out.println(result); // 5

        int one = 3;
        int anotherOne = 1;


        if (one == anotherOne) {
            System.out.println("inside the IF statement");
            System.out.println("is one");
        } else if (one == 2) {
            System.out.println("is two");
        } else {
            System.out.println("not 1 one 2");
        }
        System.out.println("after condition");

        int score = 95;
        if (score >= 70 && score < 80) {
            System.out.println("C");
        }
        if (score > 80) {
            System.out.println("B");
        } else if (score > 90) {
            System.out.println("A");
        } else {
            System.out.println("please do better");
        }

        if (true) {
            System.out.println("this is true");
            System.out.println("hello");

        }
    }


    public static int add(int a, int b) {
        System.out.println("before return"); // 3
        return a + b; // 4
    }
}
