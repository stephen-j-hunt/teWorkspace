package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizQuestion {

	private String question;
	private List<String> answers;
	private String correctAnswer;
	
	public QuizQuestion(String question, List<String> answers, String correctAnswer) {
		this.question = question;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
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
