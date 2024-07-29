package com.internal.flashcard.exceptions;

import com.internal.flashcard.model.FlashCardType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidFlashCardTypeException.class)
    public ResponseEntity<String> handleInvalidFlashCardTypeException(InvalidFlashCardTypeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        if (ex.getRequiredType() == FlashCardType.class) {
            return ResponseEntity.badRequest().body(String.format("Invalid FlashCardType: %s. Valid values are TF, DEF, or MC.", ex.getValue()));
        }
        if (ex.getRequiredType() == Long.class) {
            return ResponseEntity.badRequest().body(String.format("Invalid Id value: \"%s\". Id values must be positive integers.", ex.getValue()));
        }
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(InvalidFlashCardException.class)
    public ResponseEntity<String> handleInvalidFlashCardTFException(InvalidFlashCardException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
