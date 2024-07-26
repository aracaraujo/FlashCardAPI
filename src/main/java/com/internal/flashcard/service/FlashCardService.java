package com.internal.flashcard.service;

import com.internal.flashcard.model.*;
import com.internal.flashcard.repository.FlashCardDEFRepository;
import com.internal.flashcard.repository.FlashCardMCRepository;
import com.internal.flashcard.repository.FlashCardTFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    // GET ALL USER'S FLASHCARDS
    public FlashCardCollection getAllFlashCardsByUserID(Long userID) {
        return new FlashCardCollection(flashCardTFRepository.findAllByUserID(userID), flashCardDEFRepository.findAllByUserID(userID), flashCardMCRepository.findAllByUserID(userID));
    }

    // CREATE FLASHCARD
    public ResponseEntity<String> createFlashCard(FlashCardType type, String rawFlashCard) {
        try{
            switch (type) {
                case TF:
                    FlashCardTF flashCardTF = this.objectMapper.readValue(rawFlashCard, FlashCardTF.class);
                    this.flashCardTFRepository.save(flashCardTF);
                    return ResponseEntity
                            .created(URI.create(String.format("ID: %s", flashCardTF.getId())))
                            .body(String.format("New flashcard created id: %s", flashCardTF.getId()));
                case DEF:
                    FlashCardDEF flashCardDEF = this.objectMapper.readValue(rawFlashCard, FlashCardDEF.class);
                    this.flashCardDEFRepository.save(flashCardDEF);
                    return ResponseEntity
                            .created(URI.create(String.format("ID: %s", flashCardDEF.getId())))
                            .body(String.format("New flashcard created id: %s", flashCardDEF.getId()));
                case MC:
                    FlashCardMC flashCardMC = this.objectMapper.readValue(rawFlashCard, FlashCardMC.class);
                    this.flashCardMCRepository.save(flashCardMC);
                    return ResponseEntity
                            .created(URI.create(String.format("ID: %s", flashCardMC.getId())))
                            .body(String.format("New flashcard created id: %s", flashCardMC.getId()));
                default:
                    throw new Exception("Error with flashcard type.");
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    // DELETE FLASHCARD
    public ResponseEntity<String> deleteFlashCard(FlashCardType type, Long id) {
        try{
            switch (type) {
                case TF:
                    this.flashCardTFRepository.deleteById(id);
                    break;
                case DEF:
                    this.flashCardDEFRepository.deleteById(id);
                    break;
                case MC:
                    this.flashCardMCRepository.deleteById(id);
                    break;
                default:
                    throw new Exception("Error with flashcard type.");
            }
            return ResponseEntity.ok().body(String.format("Flashcard id: %s deleted", id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(String.format("Error trying to delete flashcard.\nError: %s",e.getMessage()));
        }
    }

    // EDIT FLASHCARD
    public ResponseEntity<String> editFlashCard(FlashCardType type, String rawFlashCard) {
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
                case MC:
                    FlashCardMC flashCardMC = this.objectMapper.readValue(rawFlashCard, FlashCardMC.class);
                    this.flashCardMCRepository.save(flashCardMC);
                    return ResponseEntity.ok().body(String.format("Flash card %s edited.\nNew value: \n%s", flashCardMC.getId(), flashCardMC));
                default:
                    throw new Exception("Error with flashcard type in editFlashCard.");
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
