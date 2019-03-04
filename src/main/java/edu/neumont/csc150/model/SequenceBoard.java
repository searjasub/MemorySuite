package edu.neumont.csc150.model;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SequenceBoard {
    private int cardAmount = 5;
    private int modfier = 1;
    private CardTypes[] cards = {CardTypes.ONE,CardTypes.TWO,CardTypes.THREE,CardTypes.FOUR,CardTypes.FIVE,CardTypes.SIX,CardTypes.SEVEN,CardTypes.EIGHT,CardTypes.NINE,CardTypes.TEN,CardTypes.ELEVEN,CardTypes.TWELVE,CardTypes.THIRTEEN,CardTypes.FOURTEEN,CardTypes.FIFTEEN,CardTypes.SIXTEEN,CardTypes.SEVENTEEN,CardTypes.EIGHTEEN
            ,CardTypes.NINETEEN,CardTypes.TWENTY,CardTypes.TWENTYONE,CardTypes.TWENTYTWO,CardTypes.TWENTYTHREE,CardTypes.TWENTYFOUR,CardTypes.TWENTYFIVE,CardTypes.TWENTYSIX,CardTypes.TWENTYSEVEN,CardTypes.TWENTYEIGHT,CardTypes.TWENTYNINE,CardTypes.THIRTY,CardTypes.THIRTYONE,CardTypes.THIRTYTWO};
    private List<CardTypes> sequence = new ArrayList<>();

    public List<CardTypes> getSequence() {
        return sequence;
    }

    public void setSequence(List<CardTypes> sequence) {
        this.sequence = sequence;
    }

    public void init(){
        generateCards();
    }

    private void generateCards(){
        this.cardAmount+= this.modfier;
        this.setSequence(null);
        for(int i = 0; i<cardAmount; i++){
            this.sequence.add(cards[(int)Math.random()*cards.length]);
        }
    }
}
