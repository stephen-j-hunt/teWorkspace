package com.techelevator;

public class FlowerOrder {

    private String bouqetType;
    private Integer numberOfRoses;

        public String getBouqetType() {
            return bouqetType;
        }

        public Integer getNumberOfRoses () {
            return numberOfRoses;
        }

    public FlowerOrder(String bouqetType, Integer numberOfRoses) {
        this.bouqetType = bouqetType;
        this.numberOfRoses = numberOfRoses;

    }

        public double getSubtotal () {
            return 19.99 + (2.99*numberOfRoses);
        }

        public String toString () {
            return "ORDER - " + bouqetType + " - " + numberOfRoses + " roses - " + getSubtotal();
        }

        public boolean sameDayDelivery (String zipCode){
            double deliveryFee = 0.0;
            if (zipCode)
            return false;
        }


    }








