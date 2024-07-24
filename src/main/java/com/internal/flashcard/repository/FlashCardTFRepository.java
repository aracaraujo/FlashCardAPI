package com.internal.flashcard.repository;

import com.internal.flashcard.model.FlashCardTF;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashCardTFRepository extends CrudRepository<FlashCardTF, Long> {

    @Query(
            value = "SELECT * FROM true_false_flashcards tf WHERE user_id=:user_id",
            nativeQuery = true)
    Iterable<FlashCardTF> findAllByUserID(@Param("user_id") Long user_id);
}
