package com.internal.flashcard;

import com.internal.flashcard.model.FlashCardTF;
import com.internal.flashcard.service.FlashCardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class FlashCardServiceTest {

    @MockBean
    private FlashCardService flashCardService;

    @Autowired
    private JacksonTester<FlashCardTF> json;

    @Test
    void flashCardTFSerializationTest() throws Exception {

        FlashCardTF flashCardTF = new FlashCardTF("Is the earth flat?", false, 1L, new Date(1725361200), new Date(1725361200));

        assertThat(json.write(flashCardTF)).isStrictlyEqualToJson("expectedTF.json");
        assertThat(json.write(flashCardTF)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(flashCardTF)).extractingJsonPathNumberValue("@.id").isEqualTo(null);
        assertThat(json.write(flashCardTF)).hasJsonPathStringValue("@.question");
        assertThat(json.write(flashCardTF)).extractingJsonPathStringValue("@.question").isEqualTo("Is the earth flat?");
        assertThat(json.write(flashCardTF)).hasJsonPathBooleanValue("@.answer");
        assertThat(json.write(flashCardTF)).extractingJsonPathBooleanValue("@.answer").isEqualTo(false);
        assertThat(json.write(flashCardTF)).hasJsonPathNumberValue("@.userId");
        assertThat(json.write(flashCardTF)).extractingJsonPathNumberValue("@.userId").isEqualTo(1);
        assertThat(json.write(flashCardTF)).hasJsonPathValue("@.dateCreation");
        assertThat(json.write(flashCardTF)).extractingJsonPathValue(".dateCreation").isEqualTo(new Date(1725361200));
        assertThat(json.write(flashCardTF)).hasJsonPathValue("@.lastModified");
        assertThat(json.write(flashCardTF)).extractingJsonPathValue(".lastModified").isEqualTo(new Date(1725361200));
    }
}
