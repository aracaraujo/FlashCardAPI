package com.internal.flashcard.model;

public class FlashCardCollection {

    private Iterable<FlashCardTF> flashCardsTF;
    private Iterable<FlashCardDefinition> flashCardsDefinition;

    public FlashCardCollection(Iterable<FlashCardTF> flashCardsTF, Iterable<FlashCardDefinition> flashCardsDefinition) {
        this.flashCardsTF = flashCardsTF;
        this.flashCardsDefinition = flashCardsDefinition;
    }

    public Iterable<FlashCardDefinition> getFlashCardsDefinition() {
        return flashCardsDefinition;
    }

    public void setFlashCardsDefinition(Iterable<FlashCardDefinition> flashCardsDefinition) {
        this.flashCardsDefinition = flashCardsDefinition;
    }

    public Iterable<FlashCardTF> getFlashCardsTF() {
        return flashCardsTF;
    }

    public void setFlashCardsTF(Iterable<FlashCardTF> flashCardsTF) {
        this.flashCardsTF = flashCardsTF;
    }
}
