package com.internal.flashcard.service;

import com.internal.flashcard.model.*;
import com.internal.flashcard.repository.FlashCardDEFRepository;
import com.internal.flashcard.repository.FlashCardMCRepository;
import com.internal.flashcard.repository.FlashCardTFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;

@Service
public class FlashCardService {

    private final FlashCardTFRepository flashCardTFRepository;

    private final FlashCardDEFRepository flashCardDEFRepository;

    private final FlashCardMCRepository flashCardMCRepository;

    private final ObjectMapper objectMapper;

    @Autowired
    public FlashCardService(FlashCardTFRepository flashCardTFRepository, FlashCardDEFRepository flashCardDEFRepository, FlashCardMCRepository flashCardMCRepository, ObjectMapper objectMapper){
        this.flashCardTFRepository = flashCardTFRepository;
        this.flashCardDEFRepository = flashCardDEFRepository;
        this.flashCardMCRepository = flashCardMCRepository;
        this.objectMapper = objectMapper;
    }

    public FlashCardCollection getAllFlashCardsByID(Long userID) {
        return new FlashCardCollection(flashCardTFRepository.findAllByUserID(userID), flashCardDEFRepository.findAllByUserID(userID));
    }

    // CREATE FLASHCARD
    public ResponseEntity<String> createFlashCardTF(QuestionType type, String rawFlashCard) {
        try{
            switch (type) {
                case TF:
                    FlashCardTF flashCardTF = this.objectMapper.readValue(rawFlashCard, FlashCardTF.class);
                    this.flashCardTFRepository.save(flashCardTF);
                    return ResponseEntity
                            .created(URI.create(String.format("/flashcard/trueOrFalse/%s", flashCardTF.getId())))
                            .body(String.format("New flashcard can be accessed through: /flashcard/trueOrFalse/%s", flashCardTF.getId()));
                case DEF:
                    FlashCardDEF flashCardDEF = this.objectMapper.readValue(rawFlashCard, FlashCardDEF.class);
                    this.flashCardDEFRepository.save(flashCardDEF);
                    return ResponseEntity
                            .created(URI.create(String.format("/flashcard/trueOrFalse/%s", flashCardDEF.getId())))
                            .body(String.format("New flashcard can be accessed through: /flashcard/trueOrFalse/%s", flashCardDEF.getId()));
                case MC:

                default:
                    return null;
            }
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    // DELETE FLASHCARD
    public ResponseEntity<String> deleteFlashCardTF(QuestionType type,Long id) {
        try{
            switch (type) {
                case TF:
                    this.flashCardTFRepository.deleteById(id);
                    return ResponseEntity.ok().body(String.format("Flashcard id: %s deleted", id));
                case DEF:
                    this.flashCardDEFRepository.deleteById(id);
                    return ResponseEntity.ok().body(String.format("Flashcard id: %s deleted", id));
//                case MC:
                default:
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Flashcard id: %s not found", id));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    // EDIT FLASHCARD
    public ResponseEntity<String> editFlashCardTF(QuestionType type, String rawFlashCard) {
        try{
            switch (type) {
                case TF:
                    FlashCardTF flashCardTF = this.objectMapper.readValue(rawFlashCard, FlashCardTF.class);
                    this.flashCardTFRepository.save(flashCardTF);
                    return ResponseEntity.ok().body(String.format("Flash card %s edited.\nNew value: %s", flashCardTF.getId(),flashCardTF));
                case DEF:
                    FlashCardDEF flashCardDEF = this.objectMapper.readValue(rawFlashCard, FlashCardDEF.class);
                    this.flashCardDEFRepository.save(flashCardDEF);
                    return ResponseEntity.ok().body(String.format("Flash card %s edited.\nNew value: \n%s", flashCardDEF.getId(), flashCardDEF));
//                case MC:
                default:
                    return null;
            }
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
