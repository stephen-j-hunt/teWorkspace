package com.techelevator;

import java.util.Scanner;

public class TempConvert {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter the temperature");
        String tempValue = input.nextLine();

        double temperatureC = Double.parseDouble(tempValue);
        double temperatureF = Double.parseDouble(tempValue);

        System.out.println("Is the temperature in Celsius or Fahrenheit?");
        //Create a new string to store user's desired scale
        String response = input.nextLine();

        //Then compare String scale (using equalsIgnoredCase) to see which conversion formula to use
        if (response.equalsIgnoreCase("c")) {
           double temperatureCelsius = (temperatureF - 32) / 1.8;
            System.out.println(temperatureCelsius);
            //Logic for converting temperature into desired scale
        }





       double temperatureFarenheit = (temperatureC * 1.8) + 32;


    }

}
