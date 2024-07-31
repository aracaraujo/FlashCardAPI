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
            String question = node.get("question").asText();
            String optionOne = node.get("optionOne").asText();
            String optionTwo = node.get("optionTwo").asText();
            String optionThree = node.get("optionThree").asText();
            String optionFour = node.get("optionFour").asText();
            int answer = node.get("answer").asInt();
            Long user_id = node.get("userId").asLong();
            return new FlashCardMC(question,optionOne,optionTwo,optionThree,optionFour,answer,user_id);
        }catch (IllegalArgumentException | JsonProcessingException | NullPointerException e){
            throw new InvalidFlashCardException("This value is not compatible to FlashCardDEF. FlashCardDEF requires String question,String optionOne, String optionTwo, String optionThree, String optionFour, int answer, and Long user_id");
        }
    }
}
