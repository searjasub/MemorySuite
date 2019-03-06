package edu.neumont.csc150.model;

import java.util.ArrayList;
import java.util.List;

public class SequenceBoard {
    private CardType[] cards = {CardType.ONE, CardType.TWO, CardType.THREE, CardType.FOUR, CardType.FIVE, CardType.SIX, CardType.SEVEN, CardType.EIGHT, CardType.NINE, CardType.TEN, CardType.ELEVEN, CardType.TWELVE, CardType.THIRTEEN, CardType.FOURTEEN, CardType.FIFTEEN, CardType.SIXTEEN, CardType.SEVENTEEN, CardType.EIGHTEEN
            , CardType.NINETEEN, CardType.TWENTY};
    private List<CardType> sequence = new ArrayList<>();
    private List<CardType> sequenceChoices = new ArrayList<>();

    public List<CardType> getSequence() {
        return sequence;
    }

    public void setSequence(List<CardType> sequence) {
        this.sequence = sequence;
    }

    public CardType[] getCards() {
        return cards;
    }

    public void setCards(CardType[] cards) {
        this.cards = cards;
    }

    public CardType getCard(int index) {
        return cards[index];
    }

    public List<CardType> getSequenceChoices() {
        return sequenceChoices;
    }

    public void setSequenceChoices(List<CardType> sequenceChoices) {
        this.sequenceChoices = sequenceChoices;
    }
}
