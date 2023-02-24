package com.techelevator;

import java.util.List;

public interface QuizDao {
    List<QuizQuestion> getQuestionsForQuiz();
}
