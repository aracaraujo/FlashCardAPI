package com.internal.flashcard.model;

import jakarta.persistence.*;

@Table(name = "definition_flashcards")
@Entity
public class FlashCardDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "question")
    private String question;
    @Column(name = "answer")
    private String answer;

    public FlashCardDefinition() {}

    public FlashCardDefinition(String question, String answer) {
        this.question = question;
        this.answer = answer;
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

    public String toString(){
        return String.format("FlashCard id: %d\nQuestion: %s\nAnswer: %b",id,question,answer);
    }
}
