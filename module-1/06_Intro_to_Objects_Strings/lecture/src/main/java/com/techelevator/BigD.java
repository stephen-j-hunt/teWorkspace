package com.techelevator;

import java.math.BigDecimal;

public class BigD {
    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("3.14");
        System.out.println(bd1);    //big decimal is immutable need to create a new one
        System.out.println(bd1);
        System.out.println(bd1.add(BigDecimal.ONE));
        System.out.println(bd1.subtract(BigDecimal.ONE));
        System.out.println(bd1.multiply(BigDecimal.TEN));
        System.out.println(bd1.divide(BigDecimal.TEN));
        BigDecimal balance = new BigDecimal("5.00");

        System.out.println(balance.compareTo(balance));//0 since the values are the same
        System.out.println(balance.compareTo(bd1));//1 since balance is larger
        System.out.println(bd1.compareTo(balance));// -1 since balance is larger

        if(balance.compareTo(balance) == 0) {
            System.out.println("same!");
        }
        BigDecimal a = new BigDecimal("1.203");
        BigDecimal b = new BigDecimal("2.1");
        System.out.println(a.add(b));
        System.out.println(b.add(a));

        BigDecimal c = new BigDecimal(.1 +.2);//may introduce the approx nature of a floating point
        System.out.println(c);
        BigDecimal d = new BigDecimal(".3");
        System.out.println(d);
    }
}
