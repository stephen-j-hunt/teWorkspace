package com.techelevator;

public class Television {

    private boolean isOn;
    private int currentChannel=3;
    private int currentVolume=2;


    public boolean isOn() {
        return isOn;
    }
    public int getCurrentChannel() {
        return currentChannel;
    }
    public int getCurrentVolume() {
        return currentVolume;
    }
    public void turnOff() {
        isOn = false;
    }
    public void turnOn() {
        isOn = true;
    }
    public void changeChannel(int newChannel) {
        if (isOn) {
            if (newChannel >=3 && newChannel <= 18) {
                currentChannel = newChannel;
            }
        }
    }
    public void channelUp() {
        if (isOn) {
            currentChannel= currentChannel + 1;
            if (currentChannel>18) {
                currentChannel = 3;
            }
        }
    }
    public void channelDown() {
        if (isOn) {
            currentChannel = currentChannel - 1;
            if (currentChannel<3) {
                currentChannel= 18;
            }
        }
    }
    public void raiseVolume() {
        if (isOn) {
            if (currentVolume<10) {
               currentVolume = currentVolume + 1;
            }
        }
    }
    public void lowerVolume() {
        if (isOn) {
          if (currentVolume>0 && currentVolume<10) {
              currentVolume= currentVolume - 1;
          }
        }
    }
}
