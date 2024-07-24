package com.internal.flashcard.controller;

import com.internal.flashcard.model.FlashCardCollection;
import com.internal.flashcard.model.FlashCardDefinition;
import com.internal.flashcard.model.FlashCardTF;
import com.internal.flashcard.model.QuestionType;
import com.internal.flashcard.service.FlashCardService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping(value = "/flashcard")
public class FlashCardController {

    private final FlashCardService flashCardService;

    public FlashCardController(FlashCardService flashCardService) {
        this.flashCardService = flashCardService;
    }

    /*
    TRUE OR FALSE FLASHCARD CONTROLLERS
     */
    // GET ALL TRUE OR FALSE FLASHCARDS
    @GetMapping(value = "/getAll/{userID}")
    public ResponseEntity<FlashCardCollection> getAllFlashCardTF(@PathVariable Long userID) {
        FlashCardCollection flashCards = flashCardService.getAllFlashCardsByID(userID);
        return ResponseEntity.ok().body(flashCards);
    }

    // CREATE FLASHCARD
    @PostMapping(value = "/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> createFlashCardTF(@PathVariable QuestionType type, @RequestBody String rawFlashCard) {
        return flashCardService.createFlashCardTF(type, rawFlashCard);
    }

    // DELETE FLASHCARDTF
    @DeleteMapping(value = "/trueOrFalse/{id}")
    public ResponseEntity<String> deleteFlashCardTF(@PathVariable Long id) {
        flashCardService.deleteFlashCardTF(id);
        return ResponseEntity
                .ok().body(String.format("Flashcard deleted id: %s", id));
    }

    // EDIT FLASHCARDTF
    @PutMapping(value = "/trueOrFalse")
    @ResponseBody
    public ResponseEntity<String> editFlashCardTF(@RequestBody FlashCardTF flashCardTF) {
        flashCardService.editFlashCardTF(flashCardTF);
        return ResponseEntity
                .ok().body(String.format("Flashcard edited id: %s \nNew value: %s", flashCardTF.getId(),flashCardTF));
    }

    /*
    DEF
    DEFINITION FLASHCARD CONTROLLERS
     */
    // GET ALL DEFINITION FLASHCARDS
    @GetMapping(value = "/definition")
//    public ResponseEntity<Iterable<FlashCardDefinition>> getAllFlashCardDefinition() {
//        Iterable<FlashCardDefinition> flashCardsDefinition = flashCardService.getAllFlashCardDefinition();
//        return ResponseEntity.ok().body(flashCardsDefinition);
//    }

    // GET DEFINITION FLASHCARD BY ID
//    @GetMapping(value = "/definition/{id}")
//    public ResponseEntity<FlashCardDefinition> getFlashCardDefinitionById(@PathVariable Long id) {
//        Optional<FlashCardDefinition> flashCardDefinition = flashCardService.getFlashCardDefinitionById(id);
//        if(flashCardDefinition.isPresent()){
//            return ResponseEntity.ok().body(flashCardDefinition.get());
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }

    // CREATE DEFINITION FLASHCARD
    @PostMapping(value = "/definition", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> createFlashCardDefinition(@RequestBody FlashCardDefinition flashCardDefinition) {
        Long id = flashCardService.createFlashCardDefinition(flashCardDefinition);
        return ResponseEntity
                .created(URI.create(String.format("/flashcard/definition/%s", id)))
                .body(String.format("New flashcard can be accessed through: /flashcard/definition/%s", id));
    }
}