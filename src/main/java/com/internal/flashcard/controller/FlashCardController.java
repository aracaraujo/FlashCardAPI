package com.internal.flashcard.controller;

import com.internal.flashcard.model.FlashCardTF;
import com.internal.flashcard.service.FlashCardService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping(value = "/flashcard")
public class FlashCardController {

    FlashCardService flashCardService;

    public FlashCardController(FlashCardService flashCardService) {
        this.flashCardService = flashCardService;
    }

    @GetMapping(value = "/AllTrueOrFalse")
    public ResponseEntity<Iterable<FlashCardTF>> getAllFlashCardTF() {
        Iterable<FlashCardTF> flashCardsTF = flashCardService.getAllFlashCardTF();
        return ResponseEntity.ok().body(flashCardsTF);
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
}