package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		Cow cow = new Cow();
		Chicken chicken = new Chicken();
		Pig pig = new Pig();

		pig.sleep();

		Cat cat = new Cat();
//		cat.sleep();

		Singable[] singables =
				new Singable[] {cow, chicken, pig, new Tractor(), cat};

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {cow, pig, new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}

		FarmAnimal[] animals = {cow, chicken, pig, cat};
		for(FarmAnimal animal : animals) {
			System.out.printf("%s would like to dine on %s\n", animal.getName(), animal.eat());
		}
	}
}
