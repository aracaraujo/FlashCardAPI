package com.internal.flashcard.model;

import jakarta.persistence.*;

@Table(name = "true_false_flashcards")
@Entity
public class FlashCardTF {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "question")
    private String question;
    @Column(name = "answer")
    private Boolean answer;
    @Column(name = "user_id")
    private Long userID;

    public FlashCardTF() {}

    public FlashCardTF(String question, Boolean answer, Long userID){
        this.question = question;
        this.answer = answer;
        this.userID = userID;
    }

    public Long getId(){
        return id;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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
