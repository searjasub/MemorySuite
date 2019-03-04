package edu.neumont.csc150.model;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

public class NumberBoard {
    private int numAmount = 5;
    private int modfier = 1;
    private List<Integer> numbers = new ArrayList<>();


    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void init(Difficulty difficulty){
        generateNumbers(difficulty);
    }
    private void generateNumbers(Difficulty difficulty){
        this.numAmount+= this.modfier;
        this.setNumbers(null);
        for(int i = 0; i<numAmount; i++){
            this.numbers.add((int)(Math.random()*difficulty.getNumgame(difficulty)+1));
        }
    }
}
