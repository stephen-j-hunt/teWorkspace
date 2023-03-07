package com.techelevator;

public class CannotLoadQuizException extends RuntimeException {
    public CannotLoadQuizException(Throwable cause) {
        super("unable to load the quiz source", cause);
    }

    public CannotLoadQuizException() {
        super("unable to load the quiz source");
    }

}
