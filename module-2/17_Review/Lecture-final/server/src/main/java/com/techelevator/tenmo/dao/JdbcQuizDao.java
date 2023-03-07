package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Answer;
import com.techelevator.tenmo.model.Question;
import com.techelevator.tenmo.model.Quiz;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcQuizDao implements QuizDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcQuizDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Quiz getById(int id) {
        final String sql = "SELECT id, name\n" +
                "FROM quizzes\n" +
                "WHERE id = ?;";

        // needs some error handling
        SqlRowSet rowSet = this.jdbcTemplate.queryForRowSet(sql, id);
        Quiz quiz = null;
        if (rowSet.next()) {
            quiz = new Quiz();
            quiz.setId(rowSet.getInt("id"));
            quiz.setName(rowSet.getString("name"));
        }

        return quiz;
    }

    @Override
    public List<Question> getQuestionsForQuiz(int id) {

        final String sql = "SELECT id, quiz_id, text\n" +
                "FROM questions\n" +
                "WHERE quiz_id = ?;";

        // need error handling
        SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sql, id);
        List<Question> questions = new ArrayList<>();
        while (rs.next()) {
            Question question = new Question();
            question.setId(rs.getInt("id"));
            question.setText(rs.getString("text"));
            questions.add(question);
        }

        return questions;
    }

    @Override
    public List<Answer> getAnswersForQuestion(int id) {

        final String sql = "SELECT id, question_id, text, isanswer\n" +
                "FROM answers\n" +
                "WHERE question_id = ?;";

        // please add error handling
        SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sql, id);
        List<Answer> answers = new ArrayList<>();
        while (rs.next()) {
            Answer answer = new Answer();
            answer.setId(rs.getInt("id"));
            answer.setText(rs.getString("text"));
            answer.setQuestionId(rs.getInt("question_id"));
            answer.setCorrectAnswer(rs.getBoolean("isanswer"));
            answers.add(answer);
        }

        return answers;
    }
}
