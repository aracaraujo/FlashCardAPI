package com.internal.flashcard.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.internal.flashcard.exceptions.InvalidFlashCardException;
import com.internal.flashcard.model.FlashCardMC;

import java.io.IOException;

public class FlashCardMCDeserializer extends JsonDeserializer<FlashCardMC> {
    @Override
    public FlashCardMC deserialize(JsonParser p, DeserializationContext deserializationContext) throws IOException, JacksonException {
        try{
            JsonNode node = p.getCodec().readTree(p);
            FlashCardMC flashCardMC = new FlashCardMC();
            if (node.has("id")) {
                flashCardMC.setId(node.get("id").asLong());
            }
            flashCardMC.setQuestion(node.get("question").asText());
            flashCardMC.setOptionOne(node.get("optionOne").asText());
            flashCardMC.setOptionTwo(node.get("optionTwo").asText());
            flashCardMC.setOptionThree(node.get("optionThree").asText());
            flashCardMC.setOptionFour(node.get("optionFour").asText());
            flashCardMC.setAnswer(node.get("answer").asInt());
            flashCardMC.setUserId(node.get("userId").asLong());
            return flashCardMC;
        }catch (IllegalArgumentException | JsonProcessingException | NullPointerException e){
            throw new InvalidFlashCardException("This value is not compatible to FlashCardDEF. FlashCardDEF requires String question,String optionOne, String optionTwo, String optionThree, String optionFour, int answer, and Long user_id");
        }
    }
}
