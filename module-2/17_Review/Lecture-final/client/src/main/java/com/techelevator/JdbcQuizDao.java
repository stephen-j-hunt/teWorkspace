package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcQuizDao implements QuizDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcQuizDao() {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Quiz");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<QuizQuestion> getQuestionsForQuiz() {
        final String getQuestionsSQL =
                "SELECT id, quiz_id, text\n" +
                "FROM questions\n" +
                "WHERE quiz_id = ?;\n";

        final String getAnswersForQuestion =
                "SELECT id, text, isanswer\n" +
                "FROM answers\n" +
                "WHERE question_id = ?;";

        List<QuizQuestion> questions = new ArrayList<>();
        SqlRowSet rowSet = this.jdbcTemplate.queryForRowSet(getQuestionsSQL, 1);
        while (rowSet.next()) {
            // question info
            int questionId = rowSet.getInt("id");
            String questionText = rowSet.getString("text");

            // answer info
            List<String> answers = new ArrayList<>();
            String corectAnswer = "";
            SqlRowSet answerRowSet = this.jdbcTemplate.queryForRowSet(getAnswersForQuestion, questionId);
            while (answerRowSet.next()) {
                String answer = answerRowSet.getString("text");
                boolean isAnswer = answerRowSet.getBoolean("isanswer");
                if (isAnswer) {
                    corectAnswer = answer;
                }
                answers.add(answer);
            }

            questions.add(new QuizQuestion(questionText, answers,corectAnswer));
        }

        return questions;
    }
}
