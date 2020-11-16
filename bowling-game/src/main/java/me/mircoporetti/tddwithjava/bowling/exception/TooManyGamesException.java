package me.mircoporetti.tddwithjava.bowling.exception;

public class TooManyGamesException extends RuntimeException{

    public TooManyGamesException(String message) {
        super(message);
    }
}


