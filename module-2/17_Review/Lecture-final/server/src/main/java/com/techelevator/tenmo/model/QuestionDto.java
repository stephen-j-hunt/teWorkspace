package com.techelevator.tenmo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class QuestionDto {
    public String text;
    @JsonProperty("correct-answer")
    public String correctAnswer;
    public List<String> answers = new ArrayList<>();
}
