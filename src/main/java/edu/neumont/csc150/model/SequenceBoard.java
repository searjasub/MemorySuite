package edu.neumont.csc150.model;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SequenceBoard {
    private CardTypes[] cards = {CardTypes.ONE,CardTypes.TWO,CardTypes.THREE,CardTypes.FOUR,CardTypes.FIVE,CardTypes.SIX,CardTypes.SEVEN,CardTypes.EIGHT,CardTypes.NINE,CardTypes.TEN,CardTypes.ELEVEN,CardTypes.TWELVE,CardTypes.THIRTEEN,CardTypes.FOURTEEN,CardTypes.FIFTEEN,CardTypes.SIXTEEN,CardTypes.SEVENTEEN,CardTypes.EIGHTEEN
            ,CardTypes.NINETEEN,CardTypes.TWENTY,CardTypes.TWENTYONE,CardTypes.TWENTYTWO,CardTypes.TWENTYTHREE,CardTypes.TWENTYFOUR};
    private List<CardTypes> sequence = new ArrayList<>();
    private List<CardTypes> sequenceChoices = new ArrayList<>();

    public List<CardTypes> getSequence() {
        return sequence;
    }

    public void setSequence(List<CardTypes> sequence) {
        this.sequence = sequence;
    }

        public CardTypes[] getCards() {
        return cards;
    }

    public void setCards(CardTypes[] cards) {
        this.cards = cards;
    }

    public CardTypes getCard(int index){
        return cards[index];
    }

    public List<CardTypes> getSequenceChoices() {
        return sequenceChoices;
    }

    public void setSequenceChoices(List<CardTypes> sequenceChoices) {
        this.sequenceChoices = sequenceChoices;
    }
}
