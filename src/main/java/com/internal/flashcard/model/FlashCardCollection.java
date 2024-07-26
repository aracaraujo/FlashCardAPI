package com.internal.flashcard.model;

public class FlashCardCollection {

    private Iterable<FlashCardTF> flashCardsTF;
    private Iterable<FlashCardDEF> flashCardsDEF;
    private Iterable<FlashCardMC> flashCardsMC;

    public FlashCardCollection(Iterable<FlashCardTF> flashCardsTF, Iterable<FlashCardDEF> flashCardsDEF, Iterable<FlashCardMC> flashCardsMC) {
        this.flashCardsTF = flashCardsTF;
        this.flashCardsDEF = flashCardsDEF;
        this.flashCardsMC = flashCardsMC;
    }

    public Iterable<FlashCardDEF> getFlashCardsDEF() {
        return flashCardsDEF;
    }

    public void setFlashCardsDEF(Iterable<FlashCardDEF> flashCardsDEF) {
        this.flashCardsDEF = flashCardsDEF;
    }

    public Iterable<FlashCardTF> getFlashCardsTF() {
        return flashCardsTF;
    }

    public void setFlashCardsTF(Iterable<FlashCardTF> flashCardsTF) {
        this.flashCardsTF = flashCardsTF;
    }

    public Iterable<FlashCardMC> getFlashCardsMC() {
        return flashCardsMC;
    }

    public void setFlashCardsMC(Iterable<FlashCardMC> flashCardsMC) {
        this.flashCardsMC = flashCardsMC;
    }
}
