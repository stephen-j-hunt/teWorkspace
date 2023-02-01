package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean isSleeping = false;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public String getName( ) {
		return name;
	}


	public final String getSound( ) {
		if (isSleeping) {
			return "Zzzzzzz";
		}
		return soundProvider();
	}

	// return the value in the sound instance variable
	// subclasses can override this method to customize
	// the sound of the animal
	protected String soundProvider() {
		return sound;
	}

	public void sleep() {
		isSleeping = true;
	}

	public void wakeup() {
		isSleeping = false;
	}

	public abstract String eat();

}
