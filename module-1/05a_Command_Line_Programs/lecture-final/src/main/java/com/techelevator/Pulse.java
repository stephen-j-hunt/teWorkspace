package com.techelevator;

public class Pulse {
    private static final int MINIMUM_NIGHTS_FOR_DISCOUNT_RATE = 1;
    private static final double DAILY_RATE = 1;
    private static final int PARKING_RATE = 1;
    private static final double LATE_CHECKOUT_FEE = 1;
    private static final int DISCOUNT_RATE = 1;

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        System.out.println(nums[0]); // smallest legal index
        System.out.println(nums[3]); // largest legal index
//        System.out.println(nums[4]); // won't work

        for (int i = 0; i <= nums.length; i++) {
            int x = nums[i];
        }
    }

    public double calculateStayTotal(int numOfTotalNights, boolean includesParking, boolean includesLateCheckout) {
        if (numOfTotalNights < MINIMUM_NIGHTS_FOR_DISCOUNT_RATE && includesParking && !includesLateCheckout) {
            return (DAILY_RATE + PARKING_RATE) * numOfTotalNights;
        } else if (numOfTotalNights < MINIMUM_NIGHTS_FOR_DISCOUNT_RATE && includesParking && includesLateCheckout) {
            return LATE_CHECKOUT_FEE + ((DAILY_RATE + PARKING_RATE) * numOfTotalNights);
        } else if (numOfTotalNights < MINIMUM_NIGHTS_FOR_DISCOUNT_RATE && !includesParking && !includesLateCheckout) {
            return DAILY_RATE * numOfTotalNights;
        } else if (numOfTotalNights < MINIMUM_NIGHTS_FOR_DISCOUNT_RATE && !includesParking && includesLateCheckout) {
            return LATE_CHECKOUT_FEE + (DAILY_RATE * numOfTotalNights);
        } else if (numOfTotalNights >= MINIMUM_NIGHTS_FOR_DISCOUNT_RATE && includesParking && includesLateCheckout) {
            return numOfTotalNights * (PARKING_RATE + DISCOUNT_RATE) + LATE_CHECKOUT_FEE;
        } else if (numOfTotalNights >= MINIMUM_NIGHTS_FOR_DISCOUNT_RATE && !includesParking && includesLateCheckout) {
            return numOfTotalNights * (DISCOUNT_RATE) + LATE_CHECKOUT_FEE;
        } else if (numOfTotalNights >= MINIMUM_NIGHTS_FOR_DISCOUNT_RATE && includesParking && !includesLateCheckout) {
            return numOfTotalNights * (PARKING_RATE + DISCOUNT_RATE);
        } else return numOfTotalNights * DISCOUNT_RATE;
    }

    public double calculateStayTotal2(int numOfTotalNights, boolean includesParking, boolean includesLateCheckout) {

        // base cost of the stay
        double baseStay = 0;
        if (numOfTotalNights >= MINIMUM_NIGHTS_FOR_DISCOUNT_RATE) {
            baseStay = numOfTotalNights * DISCOUNT_RATE;
        } else {
            baseStay = numOfTotalNights * DAILY_RATE;
        }

        // include parking?
        double feeForParking = 0;
        if (includesParking) {
            feeForParking += numOfTotalNights * PARKING_RATE;
        }

        // is there a late checkout fee
        double lateCheckoutFee = 0;
        if (includesLateCheckout) {
            lateCheckoutFee += LATE_CHECKOUT_FEE;
        }

        return baseStay + feeForParking + lateCheckoutFee;
    }

}
