package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		Cow myCow = new Cow();
		Chicken myChicken = new Chicken();
		Singable[] farmAnimals = new Singable[] {myCow, myChicken, new Dog(), new Tractor() };

		for (Singable animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Egg egg = new Egg();
		Sellable[] itemsForSale = {egg, myChicken, myCow};
		System.out.println("items for sale");
		for (Sellable item: itemsForSale) {
			System.out.printf("%s @ $%5.2f\n", item.getName(), item.getPrice());
		}
	}
}
