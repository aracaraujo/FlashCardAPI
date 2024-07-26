package com.internal.flashcard.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

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
    private Long userID;

    public FlashCardDEF() {}

    public FlashCardDEF(String question, String answer, Long userID) {
        this.question = question;
        this.answer = answer;
        this.userID = userID;
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

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String toString(){
        return String.format("FlashCard id: %d\nQuestion: %s\nAnswer: %b",id,question,answer);
    }
}
