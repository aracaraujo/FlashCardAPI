package com.internal.flashcard.controller;

import com.internal.flashcard.model.FlashCardCollection;
import com.internal.flashcard.model.FlashCardType;
import com.internal.flashcard.service.FlashCardService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/flashcard")
public class FlashCardController {

    private final FlashCardService flashCardService;

    public FlashCardController(FlashCardService flashCardService) {
        this.flashCardService = flashCardService;
    }

    // GET ALL FLASHCARDS
    @GetMapping(value = "/getAll/{userID}")
    public ResponseEntity<FlashCardCollection> getAllFlashCardTF(@PathVariable Long userID) {
        FlashCardCollection flashCards = flashCardService.getAllFlashCardsByUserID(userID);
        return ResponseEntity.ok().body(flashCards);
    }

    // CREATE FLASHCARD
    @PostMapping(value = "/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> createFlashCardTF(@PathVariable FlashCardType type, @RequestBody String rawFlashCard) {
        return flashCardService.createFlashCard(type, rawFlashCard);
    }

    // DELETE FLASHCARD
    @DeleteMapping(value = "/{type}/{id}")
    public ResponseEntity<String> deleteFlashCardTF(@PathVariable Long id, @PathVariable FlashCardType type) {
        return flashCardService.deleteFlashCard(type,id);
    }

    // EDIT FLASHCARD
    @PutMapping(value = "/{type}")
    @ResponseBody
    public ResponseEntity<String> editFlashCardTF(@PathVariable FlashCardType type, @RequestBody String rawFlashCard) {
        return flashCardService.editFlashCard(type, rawFlashCard);
    }

}