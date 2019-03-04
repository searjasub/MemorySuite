package edu.neumont.csc150.model;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

public class NumberBoard {
    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
