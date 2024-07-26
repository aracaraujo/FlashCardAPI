package com.internal.flashcard.model;

public class FlashCardCollection {

    private Iterable<FlashCardTF> flashCardsTF;
    private Iterable<FlashCardDEF> flashCardsDefinition;

    public FlashCardCollection(Iterable<FlashCardTF> flashCardsTF, Iterable<FlashCardDEF> flashCardsDefinition) {
        this.flashCardsTF = flashCardsTF;
        this.flashCardsDefinition = flashCardsDefinition;
    }

    public Iterable<FlashCardDEF> getFlashCardsDefinition() {
        return flashCardsDefinition;
    }

    public void setFlashCardsDefinition(Iterable<FlashCardDEF> flashCardsDefinition) {
        this.flashCardsDefinition = flashCardsDefinition;
    }

    public Iterable<FlashCardTF> getFlashCardsTF() {
        return flashCardsTF;
    }

    public void setFlashCardsTF(Iterable<FlashCardTF> flashCardsTF) {
        this.flashCardsTF = flashCardsTF;
    }
}
