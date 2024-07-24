package com.internal.flashcard;

import com.internal.flashcard.controller.FlashCardController;
import com.internal.flashcard.model.FlashCardTF;
import com.internal.flashcard.service.FlashCardService;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(FlashCardController.class)
public class FlashCardTFTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlashCardController flashCardController;

    @MockBean
    private FlashCardService flashCardService;

    @Test
    void shouldReturnAFlashCardTF() throws Exception {

//        FlashCardTF flashCardTF = this.flashCardService.getFlashCardTF();

    }

}
