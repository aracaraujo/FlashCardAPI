package com.internal.flashcard.exceptions;

public class InvalidFlashCardTypeException extends RuntimeException{
    public InvalidFlashCardTypeException(String message){
        super(message);
    }
}
