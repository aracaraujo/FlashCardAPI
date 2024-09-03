package com.internal.flashcard.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.internal.flashcard.exceptions.InvalidFlashCardException;
import com.internal.flashcard.model.FlashCardMC;
import com.internal.flashcard.model.FlashCardTF;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

import java.io.IOException;

public class FlashCardTFDeserializer extends JsonDeserializer<FlashCardTF> {

    @Override
    public FlashCardTF deserialize(JsonParser p, DeserializationContext ctxt) throws IOException{
        try{
            JsonNode node = p.getCodec().readTree(p);
            FlashCardTF flashCardTF = new FlashCardTF();
            if (node.has("id")) {
                flashCardTF.setId(node.get("id").asLong());
            }
            flashCardTF.setQuestion(node.get("question").asText());
            flashCardTF.setAnswer(node.get("answer").asBoolean());
            flashCardTF.setUserId(node.get("userId").asLong());
            return flashCardTF;
        }catch (IllegalArgumentException | JsonProcessingException | NullPointerException e) {
            throw new InvalidFlashCardException("This value is not compatible to FlashCardTF. FlashCardTF requires String question, Boolean answer, and Long user_id");
        }
    }
}