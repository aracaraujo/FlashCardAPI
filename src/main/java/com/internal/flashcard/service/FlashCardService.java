package com.internal.flashcard.service;

import com.internal.flashcard.model.*;
import com.internal.flashcard.repository.FlashCardDefinitionRepository;
import com.internal.flashcard.repository.FlashCardTFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;

@Service
public class FlashCardService {

    private final FlashCardTFRepository flashCardTFRepository;

    private final FlashCardDefinitionRepository flashCardDefinitionRepository;

    private final ObjectMapper objectMapper;

    @Autowired
    public FlashCardService(FlashCardTFRepository flashCardTFRepository, FlashCardDefinitionRepository flashCardDefinitionRepository, ObjectMapper objectMapper){
        this.flashCardTFRepository = flashCardTFRepository;
        this.flashCardDefinitionRepository = flashCardDefinitionRepository;
        this.objectMapper = objectMapper;
    }

    public FlashCardCollection getAllFlashCardsByID(Long userID) {
        return new FlashCardCollection(flashCardTFRepository.findAllByUserID(userID), flashCardDefinitionRepository.findAllByUserID(userID));
    }

    /*
    TRUE OR FALSE FLASHCARD METHODS
     */
    // CREATE FLASHCARD
    public ResponseEntity<String> createFlashCardTF(QuestionType type , String rawFlashCard) {
        try{
            switch (type) {
                case TF:
                    FlashCardTF flashCardTF = this.objectMapper.readValue(rawFlashCard, FlashCardTF.class);
                    this.flashCardTFRepository.save(flashCardTF);
                    return ResponseEntity
                            .created(URI.create(String.format("/flashcard/trueOrFalse/%s", flashCardTF.getId())))
                            .body(String.format("New flashcard can be accessed through: /flashcard/trueOrFalse/%s", flashCardTF.getId()));
                case DEF:
                    FlashCardDefinition flashCardDefinition = this.objectMapper.readValue(rawFlashCard, FlashCardDefinition.class);
                    this.flashCardDefinitionRepository.save(flashCardDefinition);
                    return ResponseEntity
                            .created(URI.create(String.format("/flashcard/trueOrFalse/%s", flashCardDefinition.getId())))
                            .body(String.format("New flashcard can be accessed through: /flashcard/trueOrFalse/%s", flashCardDefinition.getId()));
//                case MC:
                default:
                    return null;
            }
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    // DELETE FLASHCARDTF
    public void deleteFlashCardTF(Long id) { flashCardTFRepository.deleteById(id); }

    // EDIT FLASHCARDTF
    public void editFlashCardTF(FlashCardTF flashCardTF) { flashCardTFRepository.save(flashCardTF); }

    /*
    DEFINITION FLASHCARD METHODS
     */

    public Long createFlashCardDefinition(FlashCardDefinition flashCardDefinition) {
        flashCardDefinitionRepository.save(flashCardDefinition);
        return flashCardDefinition.getId();
    }


}
