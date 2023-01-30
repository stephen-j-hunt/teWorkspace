package com.techelevator;

public class Elevator {

    private int currentFloor = 1;
    private int numberOfFloors;
    private boolean doorOpen;

    public Elevator(int numberOfLevels) {
        this.numberOfFloors = numberOfLevels;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void openDoor() {
        this.doorOpen = true;
    }

    public void closeDoor() {
        this.doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if (!doorOpen && desiredFloor <= numberOfFloors && desiredFloor > currentFloor) {
            currentFloor = desiredFloor;
        }

    }

    public void goDown(int desiredFloor) {
        if (!doorOpen && desiredFloor >= 1 && desiredFloor <= currentFloor) {
        currentFloor = desiredFloor;
        }
    }
}



