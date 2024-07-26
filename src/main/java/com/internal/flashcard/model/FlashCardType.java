package com.internal.flashcard.model;

// TF = true or false
// DEF = definition
// MC = multiple choice

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.internal.flashcard.util.FlashCardTypeDeserializer;

@JsonDeserialize(using = FlashCardTypeDeserializer.class)
public enum FlashCardType {
    TF,
    DEF,
    MC
}

