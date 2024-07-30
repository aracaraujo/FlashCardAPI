package com.internal.flashcard.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.internal.flashcard.util.FlashCardDEFDeserializer;
import jakarta.persistence.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@JsonDeserialize(using = FlashCardDEFDeserializer.class)
@Table(name = "definition_flashcards")
@Entity
public class FlashCardDEF {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "question")
    private String question;
    @Column(name = "answer")
    private String answer;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation;
    @Column(name = "last_modified", nullable = false)
    private LocalDate lastModified;

    public FlashCardDEF() {}

    public FlashCardDEF(String question, String answer, Long userId) {
        this.question = question;
        this.answer = answer;
        this.userId = userId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String toString(){
        return String.format("FlashCard id: %d\nQuestion: %s\nAnswer: %b",id,question,answer);
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
    }
}
