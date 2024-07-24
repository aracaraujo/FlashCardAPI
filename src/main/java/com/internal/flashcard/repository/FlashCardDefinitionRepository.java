package com.internal.flashcard.repository;

import com.internal.flashcard.model.FlashCardDefinition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashCardDefinitionRepository extends CrudRepository<FlashCardDefinition, Long> {}
