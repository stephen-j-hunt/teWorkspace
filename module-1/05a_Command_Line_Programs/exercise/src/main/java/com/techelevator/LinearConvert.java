package com.techelevator;
import java.util.Scanner;
import java.math.RoundingMode;
public class LinearConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("please enter a length:");
		String length = input.nextLine();

		double lengthInt = Integer.parseInt(length);

		System.out.println("Is the length in meters or feet");
		String response = input.nextLine();

		if (response.equalsIgnoreCase("meters")) {
			double feet = (3.2808399);
			int feet1 = (int) (feet * lengthInt);
			System.out.println(length + "m." + " is " + feet1 + "ft.");

		}
		if (response.equalsIgnoreCase("feet")) {
			double meters = (0.3048);
			int meter1 = (int) (meters * lengthInt);

			System.out.println(length + "ft." + " is " + meter1 + "m.");
		}
	}

}



//m = f * 0.3048
//f = m * 3.2808399
