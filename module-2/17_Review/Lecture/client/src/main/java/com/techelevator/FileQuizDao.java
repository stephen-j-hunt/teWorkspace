package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileQuizDao implements QuizDao {

    @Override
    public List<QuizQuestion> getQuestionsForQuiz() {
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        final File inputFile = new File("test_quiz.txt");
        try (Scanner fileScanner = new Scanner(inputFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line != null && !line.isEmpty()) {    // Skip null or empty lines
                    quizQuestions.add(this.buildFromLine(line));
                }
            }
        } catch (FileNotFoundException e) {
            throw new CannotLoadQuizException(e);
        }
        return quizQuestions;
    }

    private QuizQuestion buildFromLine(String line) {
            String[] parts = line.split("\\|");

            String text = parts[0];
            List<String> answers = new ArrayList<>();
            String correctAnswer = "";
            for(String part : parts) {
                String answer = part.trim();
                if (answer.endsWith("*")) {
                    answer = answer.substring(0, answer.length()-1);	// Pull-off trailing "*" character
                    correctAnswer = answer;
                }
                answers.add( answer); // Add the answer to the list of answers
            }

            return new QuizQuestion(text, answers, correctAnswer);
    }

}
