package edu.neumont.csc150.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Sequence board.
 */
public class SequenceBoard {
    private List<CardTypes> sequence = new ArrayList<>();

    /**
     * Gets sequence.
     *
     * @return the sequence
     */
    public List<CardTypes> getSequence() {
        return sequence;
    }

    /**
     * Sets sequence.
     *
     * @param sequence the sequence
     */
    public void setSequence(List<CardTypes> sequence) {
        this.sequence = sequence;
    }
}
