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
            FlashCardDEF flashCardDEF = new FlashCardDEF();
            JsonNode node = p.getCodec().readTree(p);
            Long id;
            if (node.has("id")){
                id = node.get("id").asLong();
                flashCardDEF.setId(id);
            }
            flashCardDEF.setQuestion(node.get("question").asText());
            flashCardDEF.setAnswer(node.get("answer").asText());
            flashCardDEF.setUserId(node.get("userId").asLong());
            return flashCardDEF;
        }catch (IllegalArgumentException | JsonProcessingException | NullPointerException e){
            throw new InvalidFlashCardException("This value is not compatible to FlashCardDEF. FlashCardDEF requires String question, String answer, and Long user_id");
        }
    }
}
