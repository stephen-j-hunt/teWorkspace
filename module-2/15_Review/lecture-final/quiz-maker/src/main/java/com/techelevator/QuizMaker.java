package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * QuizMaker (Challenge level)
 *
 * Create a quiz maker program which asks the user a question, presents multiple choice answers, and allows the
 * user to specify a correct answer.
 *
 * At startup, the program will read a set of questions from an input file specified as a command line argument.
 * The questions and answers will be pipe delimited | and correct answers will be marked with an asterisk in the file.
 * Question-1|answer-1|answer-2|correct-answer*|answer-4
 *
 * Example file
 * What color is the sky?|yellow|blue*|green|red
 * What are Cleveland's odds of winning a championship?|Not likely*|Highly likely|Fat chance|Who cares??
 *
 * Tips
 * Create a class that can model a quiz question, available answers, and a correct answer.
 * While reading the input file, create an instance of the quiz question class and store it in a collection of quiz
 * questions.
 *
 * Step 1
 * Ask a single question to the user when the application is opened. Don't indicate the right answer in the list
 * of choices.
 * Example
 * What color is the sky?
 * 1. Yellow
 * 2. Blue
 * 3. Green
 * 4. Red
 *
 * Your answer: 2
 *
 * WRONG!
 *
 * Step 2
 *
 * Go through all of the available quiz questions and ask the user each one sequentially, recording how many answers
 * they got correct.
 *
 * Example
 * What color is the sky?
 * 1. Yellow
 * 2. Blue
 * 3. Green
 * 4. Red
 *
 * Your answer: 2
 *
 * WRONG!
 *
 * A skeleton walks into a bar, and says to the bartender, "Give me a beer and a ..."
 * 1. hair brush
 * 2. dry erase marker
 * 3. mop
 * 4. yo-yo
 *
 * Your answer: 3
 *
 * RIGHT!
 *
 * You got 1 answers correct out of the total 2 questions asked
 */
public class QuizMaker {

    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        QuizMaker quizMaker = new QuizMaker();
        quizMaker.run();
    }

    public void run() {

        // Read through the input file, and build of list of questions, one line at a time.
//        QuizDao dao = new FileQuizDao();
//         QuizDao dao = new JdbcQuizDao();
        QuizDao dao = new ApiQuizDao();

        List<QuizQuestion> quizQuestions = dao.getQuestionsForQuiz();

        // Deliver the quiz by displaying the questions along with their possible answers one question at a time. Keep track
        // of the number of questions asked, and the number of correct answers.
        int numberOfQuestions = 0;
        int numberOfCorrectAnswers = 0;
        for (QuizQuestion quizQuestion : quizQuestions) {
            numberOfQuestions += 1;
            System.out.println("\n" + quizQuestion.getQuestion());

            int promptNumber = 1;
            List<String> answers = quizQuestion.getAnswers();
            for (String answer : answers) {
                System.out.printf("%d) %s\n", promptNumber, answer);
                promptNumber++;
            }

            int userSelection = getSelection(1, answers.size());
            String selectedAnswer = answers.get(userSelection - 1);
            if (quizQuestion.isCorrectAnswer(selectedAnswer)) {
                System.out.println("Correct!");
                numberOfCorrectAnswers += 1;
            } else {
                System.out.println("Sorry that isn't correct!");
            }

        }

        System.out.println("You got " + numberOfCorrectAnswers + " answers correct out of the total " + numberOfQuestions + " questions asked.");
    }

    private int getSelection(int min, int max) {
        while (true) {
            System.out.println("\nYour answer?");
            String userAnswer = userInput.nextLine();
            try {
                int val = Integer.parseInt(userAnswer);
                if (val >= min && val <= max) {
                    return val;
                }
                System.out.println("not a valid option.");
            } catch (NumberFormatException e) {
                System.out.println("Enter a number");
            }
        }

    }

}
