package edu.neumont.csc150.model;

import java.util.ArrayList;
import java.util.List;

public class SequenceBoard {
    private List<CardTypes> sequence = new ArrayList<>();

    public List<CardTypes> getSequence() {
        return sequence;
    }

    public void setSequence(List<CardTypes> sequence) {
        this.sequence = sequence;
    }
}
