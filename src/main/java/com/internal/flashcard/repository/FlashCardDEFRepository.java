package com.internal.flashcard.repository;

import com.internal.flashcard.model.FlashCardDEF;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashCardDEFRepository extends CrudRepository<FlashCardDEF, Long> {

    @Query(
            value = "SELECT * FROM definition_flashcards def WHERE def.user_id=:user_id",
            nativeQuery = true)
    Iterable<FlashCardDEF> findAllByUserID(@Param("user_id") Long user_id);

}