package com.techelevator;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiQuizDao implements QuizDao {
    @Override
    public List<QuizQuestion> getQuestionsForQuiz() {

        final RestTemplate restTemplate = new RestTemplate();

        try {
            QuizDto quizDto = restTemplate.getForObject("http://localhost:3000/quizzes/1", QuizDto.class);
            List<QuizQuestion> questions = new ArrayList<>();
            for(QuestionDto questionDto : quizDto.questions) {
                questions.add(questionDto.toQuizQuestion());
            }
            return questions;
        } catch (RestClientResponseException | ResourceAccessException e) {
            throw new CannotLoadQuizException(e);
        }
    }

    private static class QuestionDto {
        public String text;
        @JsonProperty("correct-answer")
        public String correctAnswer;
        public String[] answers;

        public QuizQuestion toQuizQuestion() {
            return new QuizQuestion(this.text, Arrays.asList(answers), this.correctAnswer);
        }
    }

    private static class QuizDto {
        public int id;
        public String name;
        public QuestionDto[] questions;
    }
}
