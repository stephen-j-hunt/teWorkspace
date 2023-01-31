package com.techelevator.farm;

import java.math.BigDecimal;

public class Egg implements Sellable {
    public String getName() {
        return "Egg";
    }

    public BigDecimal getPrice() {
        return new BigDecimal("0.80");
    }
}
