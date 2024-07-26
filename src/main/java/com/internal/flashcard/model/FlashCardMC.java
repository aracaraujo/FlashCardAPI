package com.internal.flashcard.model;

import jakarta.persistence.*;
import java.util.List;

@Table(name = "multiple_choice_flashcards")
@Entity
public class FlashCardMC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public FlashCardMC(String question, int answer, Long userID) {
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

    public String toString(){
        return String.format("FlashCard id: %d\nQuestion: %s\nAnswer: %b",id,question,answer);
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
}
