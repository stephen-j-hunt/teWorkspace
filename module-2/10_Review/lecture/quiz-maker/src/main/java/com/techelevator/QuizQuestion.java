package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizQuestion {

	private String question;
	private List<String> answers;
	private String correctAnswer;
	
	/**
	 * Parses the bar-delimited line into its constituent parts: question, answers, and correctAnswer
	 * 
	 * @param line
	 */
	public QuizQuestion(String line) {
		if (line != null && !line.isEmpty()) {	// Skip null or empty lines
			String[] parts = line.split("\\|");
			this.question = parts[0];
			answers = new ArrayList<>();
			for(String part : parts) {
				String answer = part.trim();
				if (answer.endsWith("*")) {
					answer = answer.substring(0, answer.length()-1);	// Pull-off trailing "*" character
					this.correctAnswer = answer;
				}
				answers.add( answer); // Add the answer to the list of answers
			}
		}
	}
	
	/**
	 * Returns the question.
	 * 
	 * @return
	 */
	public String getQuestion() {
		return this.question;
	}
	
	/**
	 * Returns a copy of the original answers, so caller never gains access to the private array.
	 * 
	 * @return
	 */
	public List<String> getAnswers() {
		return Collections.unmodifiableList(this.answers); // Return a copy, preserving the original
	}
	
	/**
	 * Determines if the answer selected by the user is correct.
	 * 
	 * @param selectedAnswer
	 * @return true if selectedAnswer is the correctAnswer
	 */
	public boolean isCorrectAnswer(String selectedAnswer) {
		return this.correctAnswer.equalsIgnoreCase(selectedAnswer);
	}
	
}
