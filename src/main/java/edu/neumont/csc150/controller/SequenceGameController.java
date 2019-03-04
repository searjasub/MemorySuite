package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.SequenceBoard;

public class SequenceGameController {
  private SequenceBoard board = new SequenceBoard();
    private int cardAmount = 5;

    public void init(){
        generateCards();
    }

    private void generateCards(){
        this.board.getSequence().clear();
        for(int i = 0; i<cardAmount; i++){
            this.board.getSequence().add(this.board.getCard((int)Math.random()*this.board.getCards().length));
        }
        this.cardAmount++;
    }
}
