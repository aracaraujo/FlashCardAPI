package com.internal.flashcard.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.internal.flashcard.util.FlashCardMCDeserializer;
import jakarta.persistence.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@JsonDeserialize(using = FlashCardMCDeserializer.class)
@Table(name = "multiple_choice_flashcards")
@Entity
public class FlashCardMC {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "question")
    private String question;
    @Column(name = "option_one")
    private String optionOne;
    @Column(name = "option_two")
    private String optionTwo;
    @Column(name = "option_three")
    private String optionThree;
    @Column(name = "option_four")
    private String optionFour;
    @Column(name = "answer")
    private int answer;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation;
    @Column(name = "last_modified", nullable = false)
    private LocalDate lastModified;

    public FlashCardMC() {}

    public FlashCardMC(String question,String optionOne, String optionTwo, String optionThree, String optionFour, int answer, Long userId) {
        this.question = question;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.answer = answer;
        this.userId = userId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
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

    public String getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(String optionOne) {
        this.optionOne = optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(String optionTwo) {
        this.optionTwo = optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(String optionThree) {
        this.optionThree = optionThree;
    }

    public String getOptionFour() {
        return optionFour;
    }

    public void setOptionFour(String optionFour) {
        this.optionFour = optionFour;
    }

    public String toString(){
        return String.format("FlashCard id: %d\nQuestion: %s\nOption One: %s\nOption Two: %s\nOption Three: %s\nOption Four: %s\nAnswer: %d",id,question,optionOne,optionTwo,optionThree,optionFour,answer);
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

    public void setId(Long id) {
        this.id = id;
    }
}
