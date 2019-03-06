package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.SequenceBoard;
import edu.neumont.csc150.view.SequenceGameSettingsView;
import edu.neumont.csc150.view.SequenceGameView;
import edu.neumont.csc150.view.ViewNavigator;

public class SequenceGameController {


    private SequenceGameView view;
    private SequenceGameSettingsView settings;
    private ViewNavigator viewNavigator;

    private SequenceBoard board = new SequenceBoard();
    private int cardAmount = 5;
    private int wrongCards = 2;

    public SequenceGameController(SequenceGameSettingsView settings) {
        this.settings = settings;
    }

    public SequenceGameController(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
    }

    public void init() {
        generateCards();
        generateChoices();
    }

    private void generateCards() {
        this.board.getSequence().clear();
        for (int i = 0; i < cardAmount; i++) {
            this.board.getSequence().add(this.board.getCard((int) Math.random() * this.board.getCards().length));
        }
        this.cardAmount++;
    }

    private void generateChoices() {
        this.board.getSequenceChoices().clear();
        this.board.setSequence(this.board.getSequence());
        for (int i = 0; i < wrongCards; i++) {
            this.board.getSequenceChoices().add(this.board.getCard((int) Math.random() * this.board.getCards().length));
        }
        this.wrongCards++;
    }
}
