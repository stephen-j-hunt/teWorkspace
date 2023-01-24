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
        String response = input.nextLine();

        if (response.equalsIgnoreCase("c")) {
            double temperatureCelsius = (temperatureF - 32) / 1.8;
            System.out.println(temperatureCelsius);

        }
        if (response.equalsIgnoreCase("f")) {
            double temperatureFarenheit = (temperatureC * 1.8) + 32;
            System.out.println(temperatureFarenheit);
        }
    }

}
