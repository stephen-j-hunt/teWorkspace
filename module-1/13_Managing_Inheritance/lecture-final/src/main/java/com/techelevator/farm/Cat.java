package com.techelevator.farm;

public final class Cat extends FarmAnimal {
    public Cat() {
        super("Cat", "");
    }

    public String eat() {
        return "milk";
    }

    @Override
    protected String soundProvider() {
        if (Math.random() > 0.5) {
            return "purrrrr";
        }
        return "meow";
    }

}
