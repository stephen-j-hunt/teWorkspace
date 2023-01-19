package com.techelevator;

public class Scopes {
    public static void main(String[] args) {

        int var = 0;
        int var1 = 1;
        System.out.println(var);

        {
            int y = 0;
            int x = 0;
            System.out.println(var);
            x = 4;
        }

        
        if (true) {
            if (true) {
                if (true) {
                    if (true) {

                    }
                }
            }
        }

    }

    public static int calculateTotal() {
        String state = "";
        int weight = 20;
        int cost = 4;
        if (state == "OH" && weight < 10) {
            return cost + 4;
        } else if (state == "OH") {
            return cost;
        } else if (state != "OH" && weight < 10) {
            return cost * 8;
        } else {
            return cost + 40;
        }
    }

    public static int betterCalcTotal() {
        int cost = 10;
        String state = "OH";
        int weight = 40;

        int fee = 0;
        int shipping = 0;

        if (state == "OH") {
            fee = 0;
        } else {
            fee = 10;
        }


        if (weight > 40) {
            shipping = 100;
        } else {
            shipping = 10;
        }
        return cost + shipping + fee;
    }
}
