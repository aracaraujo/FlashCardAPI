package com.internal.flashcard.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.internal.flashcard.util.FlashCardMCDeserializer;
import jakarta.persistence.*;

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
    private Long userID;

    public FlashCardMC() {}

    public FlashCardMC(String question,String optionOne, String optionTwo, String optionThree, String optionFour, int answer, Long userID) {
        this.question = question;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.answer = answer;
        this.userID = userID;
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

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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
        return String.format("FlashCard id: %d\nQuestion: %s\n:Option One: %s\n:Option Two: %s\n:Option Three: %s\n:Option Four: %s\nAnswer: %b",id,question,optionOne,optionTwo,optionThree,optionFour,answer);
    }
}
