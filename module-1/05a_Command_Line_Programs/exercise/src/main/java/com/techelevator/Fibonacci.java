package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("please enter a number:");
		String length = input.nextLine();
		int length1 = Integer.parseInt(length);
		System.out.print("0, 1");
		int before = 1;

		for (int next = 1; next <= length1;) {
			System.out.print(", "+ next);
			int latest = before + next;
			before = next;
			next = latest;


		}




	}

}
