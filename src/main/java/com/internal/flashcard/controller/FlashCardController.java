package com.internal.flashcard.controller;

import com.internal.flashcard.model.FlashCardDefinition;
import com.internal.flashcard.model.FlashCardTF;
import com.internal.flashcard.service.FlashCardService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@Controller
@RequestMapping(value = "/flashcard")
public class FlashCardController {

    FlashCardService flashCardService;

    public FlashCardController(FlashCardService flashCardService) {
        this.flashCardService = flashCardService;
    }

    /*
    TRUE OR FALSE FLASHCARD CONTROLLERS
     */
    @GetMapping(value = "/TrueOrFalse")
    public ResponseEntity<Iterable<FlashCardTF>> getAllFlashCardTF() {
        Iterable<FlashCardTF> flashCardsTF = flashCardService.getAllFlashCardTF();
        return ResponseEntity.ok().body(flashCardsTF);
    }

    @GetMapping(value = "/TrueOrFalse/{id}")
    public ResponseEntity<FlashCardTF> getFlashCardTFById(@PathVariable Long id) {
        Optional<FlashCardTF> flashCardTF = flashCardService.getFlashCardTFById(id);
        if(flashCardTF.isPresent()){
            return ResponseEntity.ok().body(flashCardTF.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/TrueOrFalse", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> createFlashCardTF(@RequestBody FlashCardTF flashCardTF) {
        Long id = flashCardService.createFlashCardTF(flashCardTF);
        return ResponseEntity
                .created(URI.create(String.format("/flashcard/TrueOrFalse/%s", id)))
                .body(String.format("New flashcard can be accessed through: /flashcard/TrueOrFalse/%s", id));
    }

    @DeleteMapping(value = "/TrueOrFalse/{id}")
    public ResponseEntity<String> deleteFlashCardTF(@PathVariable Long id) {
        flashCardService.deleteFlashCardTF(id);
        return ResponseEntity
                .ok().body(String.format("Flashcard deleted: /flashcard/TrueOrFalse/%s", id));
    }

    /*
    DEFINITION FLASHCARD CONTROLLERS
     */
    @GetMapping(value = "/Definition")
    public ResponseEntity<Iterable<FlashCardDefinition>> getAllFlashCardDefinition() {
        Iterable<FlashCardDefinition> flashCardsDefinition = flashCardService.getAllFlashCardDefinition();
        return ResponseEntity.ok().body(flashCardsDefinition);
    }
}