package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.SequenceBoard;

public class SequenceGameController {
  private SequenceBoard board = new SequenceBoard();
    private int cardAmount = 5;
    private int wrongCards = 2;

    public void init(){
        generateCards();
        generateChoices();
    }

    private void generateCards(){
        this.board.getSequence().clear();
        for(int i = 0; i<cardAmount; i++){
            this.board.getSequence().add(this.board.getCard((int)Math.random()*this.board.getCards().length));
        }
        this.cardAmount++;
    }

    private void generateChoices(){
        this.board.getSequenceChoices().clear();
        this.board.setSequence(this.board.getSequence());
        for (int i = 0; i <wrongCards; i++) {
            this.board.getSequenceChoices().add(this.board.getCard((int)Math.random()*this.board.getCards().length));
        }
        this.wrongCards++;
    }
}
