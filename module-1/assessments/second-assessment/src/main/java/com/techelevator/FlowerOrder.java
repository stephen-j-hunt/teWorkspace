package com.techelevator;

import org.w3c.dom.ls.LSOutput;

public class FlowerOrder {
    String boquetType;
    int numberOfRoses;
    double subtotal;

    public FlowerOrder(String boquetType, int numberOfRoses) {

    }

    public String getBoquetType() {
        return boquetType;
    }

    public int getNumberOfRoses() {
        return numberOfRoses;
    }

    public double getSubtotal() {
        return 19.99 + numberOfRoses;
    }
    public String toString() {
        return "ORDER - " + boquetType + " - " + numberOfRoses + "roses - " + subtotal;
    }

    public boolean sameDayDelivery(String zipCode) {
        double deliveryFee = 0.0;
        if (zipCode.toString(""))
    }
}





