package com.internal.flashcard.service;

import com.internal.flashcard.model.FlashCardTF;
import com.internal.flashcard.repository.FlashCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlashCardService {

    @Autowired
    public FlashCardService(){}

    @Autowired
    private FlashCardRepository flashCardRepository;

    public Iterable<FlashCardTF> getAllFlashCardTF() {
        return flashCardRepository.findAll();
    }

    public FlashCardTF getFlashCardTF() {
        return new FlashCardTF("Is this working?", true);
    }

    public Long createFlashCardTF(FlashCardTF flashCardTF) {
        flashCardRepository.save(flashCardTF);
        return flashCardTF.getId();
    }

    public void deleteFlashCardTF(Long id) { flashCardRepository.deleteById(id); }
}
