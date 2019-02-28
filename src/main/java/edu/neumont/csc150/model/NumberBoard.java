package edu.neumont.csc150.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Number board.
 */
public class NumberBoard {
    private List<CardTypes> numbers = new ArrayList<>();

    /**
     * Gets numbers.
     *
     * @return the numbers
     */
    public List<CardTypes> getNumbers() {
        return numbers;
    }

    /**
     * Sets numbers.
     *
     * @param numbers the numbers
     */
    public void setNumbers(List<CardTypes> numbers) {
        this.numbers = numbers;
    }
}
