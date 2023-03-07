package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.QuizDao;
import com.techelevator.tenmo.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    private QuizDao dao;

    public QuizController(QuizDao dao) {
        this.dao = dao;
    }

    @GetMapping("{id}")
    public QuizDto getQuizbyId(@PathVariable int id) {

        // quiz
        final Quiz quiz = dao.getById(id);
        if (quiz == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no quiz with that ID");
        }

        final QuizDto quizDto = new QuizDto();
        quizDto.id = quiz.getId();
        quizDto.name = quiz.getName();

        // quiz questions
        final List<Question> questions = dao.getQuestionsForQuiz(id);
        for(Question q : questions) {
            QuestionDto questionDto = new QuestionDto();
            questionDto.text = q.getText();

            // question answers
            List<Answer> answers = this.dao.getAnswersForQuestion(q.getId());
            for (Answer a : answers) {
                if (a.isCorrectAnswer()) {
                    questionDto.correctAnswer = a.getText();
                }
                questionDto.answers.add(a.getText());
            }

            quizDto.questions.add(questionDto);
        }


        return quizDto;
    }

}
