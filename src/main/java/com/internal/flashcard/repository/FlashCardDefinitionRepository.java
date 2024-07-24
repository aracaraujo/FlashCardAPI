package com.internal.flashcard.repository;

import com.internal.flashcard.model.FlashCardDefinition;
import com.internal.flashcard.model.FlashCardTF;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashCardDefinitionRepository extends CrudRepository<FlashCardDefinition, Long> {

    @Query(
            value = "SELECT * FROM definition_flashcards tf WHERE tf.user_id=:user_id",
            nativeQuery = true)
    Iterable<FlashCardDefinition> findAllByUserID(@Param("user_id") Long user_id);

}