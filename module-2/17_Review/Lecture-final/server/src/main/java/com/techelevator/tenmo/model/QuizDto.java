package com.techelevator.tenmo.model;

import java.util.ArrayList;
import java.util.List;

public class QuizDto {
    public int id;
    public String name;
    public List<QuestionDto> questions = new ArrayList<>();
}
