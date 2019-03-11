package edu.neumont.csc150.model;

import javafx.scene.control.Label;

import java.io.Serializable;

public class MemBoardSquare extends Label {

    private CardType type;

    private boolean matched = false;

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }
}
