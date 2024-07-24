package com.internal.flashcard.model;

import jakarta.persistence.*;

@Table(name = "true_or_false_flashcards")
@Entity
public class FlashCardTF {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "question")
    private String question;
    @Column(name = "answer")
    private Boolean answer;

    public FlashCardTF() {}

    public FlashCardTF(String question, Boolean answer){
        this.question = question;
        this.answer = answer;
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

    public String toString(){
        return String.format("FlashCard id: %d\nQuestion: %s\nAnswer: %b",id,question,answer);
    }
}
