package edu.neumont.csc150.model;

import javafx.scene.control.Label;

public class MemBoardSquare extends Label {

    private CardType type;

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

}
