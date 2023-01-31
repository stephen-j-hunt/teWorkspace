package com.techelevator.farm;

import java.math.BigDecimal;
import java.util.Comparator;

public class Cow extends FarmAnimal implements Sellable {

	public Cow() {
		super("Cow", "moo!");
	}

	@Override
	public BigDecimal getPrice() {
		return new BigDecimal("500.00");
	}
}
