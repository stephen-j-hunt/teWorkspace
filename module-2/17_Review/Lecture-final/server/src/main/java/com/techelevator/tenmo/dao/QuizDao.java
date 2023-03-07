package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Answer;
import com.techelevator.tenmo.model.Question;
import com.techelevator.tenmo.model.Quiz;

import java.util.List;

public interface QuizDao {

    Quiz getById(int id);

    List<Question> getQuestionsForQuiz(int id);

    List<Answer> getAnswersForQuestion(int id);
}
