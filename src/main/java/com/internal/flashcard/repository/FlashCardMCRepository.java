package com.internal.flashcard.repository;

import com.internal.flashcard.model.FlashCardDEF;
import com.internal.flashcard.model.FlashCardMC;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashCardMCRepository extends CrudRepository<FlashCardMC, Long> {

    @Query(
            value = "SELECT * FROM multiple_choice_flashcards mc WHERE mc.user_id=:user_id",
            nativeQuery = true)
    Iterable<FlashCardMC> findAllByUserID(@Param("user_id") Long user_id);

    @Query(
            value = "SELECT COUNT(1) FROM multiple_choice_flashcards mc WHERE mc.user_id=:user_id",
            nativeQuery = true)
    int existsByUserId(@Param("user_id") Long user_id);
}
