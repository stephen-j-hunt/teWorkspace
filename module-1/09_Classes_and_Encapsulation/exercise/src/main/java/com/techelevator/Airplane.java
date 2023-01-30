package com.techelevator;

public class Airplane {

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    public int getAvailableFirstClassSeats() {
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }


    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfDesiredSeats) {
        if (forFirstClass) {
            if (totalNumberOfDesiredSeats <= getAvailableFirstClassSeats()) {
                bookedFirstClassSeats += totalNumberOfDesiredSeats;
                return true;
            }
        } else {
            if (totalNumberOfDesiredSeats <= getAvailableCoachSeats()) {
                bookedCoachSeats += totalNumberOfDesiredSeats;
                return true;
            }
        }
        return false;
    }
}

