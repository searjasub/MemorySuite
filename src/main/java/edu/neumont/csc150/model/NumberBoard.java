package edu.neumont.csc150.model;

import java.util.ArrayList;
import java.util.List;

public class NumberBoard {
    private List<CardTypes> numbers = new ArrayList<>();

    public List<CardTypes> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<CardTypes> numbers) {
        this.numbers = numbers;
    }
}
