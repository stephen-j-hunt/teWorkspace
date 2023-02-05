package com.techelevator;

import java.math.BigDecimal;

public class BD {
    public static void main(String[] args) {

        System.out.println(0.1 + 0.2);

        BigDecimal bd = new BigDecimal("0.300");
        System.out.println(bd);
        BigDecimal afterAdding3 = bd.add(new BigDecimal(3));
        System.out.println(afterAdding3);
        BigDecimal total = BigDecimal.ZERO;

    }
}
