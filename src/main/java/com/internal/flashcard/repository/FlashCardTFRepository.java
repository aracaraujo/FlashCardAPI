package com.internal.flashcard.repository;

import com.internal.flashcard.model.FlashCardTF;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashCardTFRepository extends CrudRepository<FlashCardTF, Long> {}
