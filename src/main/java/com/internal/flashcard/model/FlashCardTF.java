package com.internal.flashcard.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.internal.flashcard.util.FlashCardTFDeserializer;
import jakarta.persistence.*;
import java.util.Date;
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
    private Long userId;
    @Column(name = "date_creation", nullable = false)
    private Date dateCreation;
    @Column(name = "last_modified", nullable = false)
    private Date lastModified;

    public FlashCardTF() {}

    public FlashCardTF(String question, Boolean answer, Long userId){
        this.question = question;
        this.answer = answer;
        this.userId = userId;
        this.dateCreation = new Date();
        this.lastModified = new Date();
    }

    public FlashCardTF(String question, Boolean answer, Long userId, Date dateCreation, Date lastModified){
        this.question = question;
        this.answer = answer;
        this.userId = userId;
        this.dateCreation = dateCreation;
        this.lastModified = lastModified;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String toString(){
        return String.format("FlashCard id: %d\nQuestion: %s\nAnswer: %b\nUser ID: %s",id,question,answer, userId);
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dataTimeCreation) {
        this.dateCreation = dataTimeCreation;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
