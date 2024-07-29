package com.internal.flashcard.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.internal.flashcard.util.FlashCardTFDeserializer;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@JsonDeserialize(using = FlashCardTFDeserializer.class)
@Table(name = "true_false_flashcards")
@Entity
public class FlashCardTF {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "question", nullable = false)
    private String question;
    @Column(name = "answer", nullable = false)
    private Boolean answer;
    @Column(name = "user_id", nullable = false)
    private Long user_id;

    public FlashCardTF() {}

    public FlashCardTF(String question, Boolean answer, Long user_id){
        this.question = question;
        this.answer = answer;
        this.user_id = user_id;
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String toString(){
        return String.format("FlashCard id: %d\nQuestion: %s\nAnswer: %b\nUser ID: %s",id,question,answer, user_id);
    }
}
