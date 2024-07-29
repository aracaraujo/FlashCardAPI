package com.internal.flashcard.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.internal.flashcard.exceptions.InvalidFlashCardTypeException;
import com.internal.flashcard.model.FlashCardType;

import java.io.IOException;

public class FlashCardTypeDeserializer extends JsonDeserializer<FlashCardType> {

    @Override
    public FlashCardType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText().toUpperCase();
        try{
            return FlashCardType.valueOf(value);
        }catch(IllegalArgumentException e){
            throw new InvalidFlashCardTypeException(String.format("Invalid FlashCardType: %s",value));
        }
    }
}
