package com.techelevator;

public class HomeworkAssignment {


    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public int getEarnedMarks() {
        return earnedMarks;

    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public String getLetterGrade() {
        double grade = (double) earnedMarks / (double) possibleMarks * 100;
        if (grade >= 90)
            return "A";
        else if (grade >= 80 && grade <= 89)
            return "B";
        else if (grade >= 70 && grade <= 79)
            return "C";
        else if (grade >= 60 && grade <= 69)
            return "D";
        else
            return "F";
    }
}





