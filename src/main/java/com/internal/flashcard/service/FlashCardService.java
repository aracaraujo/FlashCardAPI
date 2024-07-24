package com.internal.flashcard.service;

import com.internal.flashcard.model.FlashCardDefinition;
import com.internal.flashcard.model.FlashCardTF;
import com.internal.flashcard.repository.FlashCardDefinitionRepository;
import com.internal.flashcard.repository.FlashCardTFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlashCardService {

    @Autowired
    public FlashCardService(){}

    @Autowired
    private FlashCardTFRepository flashCardTFRepository;

    @Autowired
    private FlashCardDefinitionRepository flashCardDefinitionRepository;

    /*
    TRUE OR FALSE FLASHCARD METHODS
     */
    public Iterable<FlashCardTF> getAllFlashCardTF() {
        return flashCardTFRepository.findAll();
    }

    public Optional<FlashCardTF> getFlashCardTFById(Long id) {
        return flashCardTFRepository.findById(id);
    }

    public Long createFlashCardTF(FlashCardTF flashCardTF) {
        flashCardTFRepository.save(flashCardTF);
        return flashCardTF.getId();
    }

    public void deleteFlashCardTF(Long id) { flashCardTFRepository.deleteById(id); }

    /*
    DEFINITION FLASHCARD METHODS
     */
    public Iterable<FlashCardDefinition> getAllFlashCardDefinition() {
        return flashCardDefinitionRepository.findAll();
    }
}
