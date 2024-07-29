package com.internal.flashcard.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.internal.flashcard.exceptions.InvalidFlashCardException;
import com.internal.flashcard.model.FlashCardDEF;

import java.io.IOException;

public class FlashCardDEFDeserializer extends JsonDeserializer<FlashCardDEF> {

    @Override
    public FlashCardDEF deserialize(JsonParser p, DeserializationContext deserializationContext) throws IOException, JacksonException {
        try{
            JsonNode node = p.getCodec().readTree(p);
            String question = node.get("question").asText();
            String answer = node.get("answer").asText();
            Long user_id = node.get("user_id").asLong();
            return new FlashCardDEF(question,answer,user_id);
        }catch (IllegalArgumentException | JsonProcessingException | NullPointerException e){
            throw new InvalidFlashCardException("This value is not compatible to FlashCardDEF. FlashCardDEF requires String question, String answer, and Long user_id");
        }
    }
}
