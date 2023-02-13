package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		QuizMaker quizMaker = new QuizMaker();
		quizMaker.run();
	}

	public void run() {
		/* Your code goes here */
		try (userInput) {
			System.out.println("What is the file your looking for?");
			String fileName = userInput.nextLine();
			File questionsFile = new File(fileName);

			try (Scanner quizFile =new Scanner(questionsFile)) {



			} catch (FileNotFoundException e) {
				System.out.println("File not found");;
			}


		}
	}
}
