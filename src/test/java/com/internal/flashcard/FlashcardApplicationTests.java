package com.internal.flashcard;

import com.internal.flashcard.controller.FlashCardController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FlashcardApplicationTests {

	@Autowired
	private FlashCardController flashCardController;

	@Test
	void contextLoads() throws Exception{
		assertThat(flashCardController).isNotNull();
	}

}
