package edu.neumont.csc150.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MemBoard {
    private int width;
    private int height;
    private MemBoardSquare[][] boardSquares;

    public void initBoard() {
        int r = width;
        int c = height;
        boardSquares = new MemBoardSquare[r][c];
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                MemBoardSquare mbs = new MemBoardSquare();
                mbs.setType(CardType.DEFAULT);
                boardSquares[row][col] = mbs;
            }
        }
    }

    public int getWidth() {
        return width;
    }


    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public MemBoardSquare[][] getBoardSquares() {
        return boardSquares;
    }

    public MemBoardSquare getBoardSquare(int r, int c) {
        return this.getBoardSquares()[r][c];
    }


    public void setBoardSquares(MemBoardSquare[][] boardSquares) {
        this.boardSquares = boardSquares;
    }

    public void setBoardSquare(int r, int c, CardType cardType) {
        boardSquares[r][c].setType(cardType);
    }

    // ! TODO !
    public CardType getCard(int r, int c) {
        return boardSquares[r][c].getType();
    }

    public void shuffleCards() {
        List<MemBoardSquare> cards = new ArrayList<>();
        for (int w = 0; w < this.getWidth(); w++) {
            for (int h = 0; h < this.getHeight(); h++) {
                cards.add(this.getBoardSquare(w, h));
                this.setBoardSquare(w, h, CardType.DEFAULT);
            }
        }
        Collections.shuffle(cards);
        MemBoardSquare[] card = cards.toArray(new MemBoardSquare[cards.size()]);

        Random rng = new Random();
        for (int i = 0; i < Integer.MAX_VALUE && cards.size() > 0; i++) {
            int r = rng.nextInt(this.getHeight() - 1);
            int c = rng.nextInt(this.getWidth() - 1);
            MemBoardSquare mbs = this.getBoardSquare(r, c);
            if (mbs.getType() == CardType.DEFAULT) {
                mbs = card[i];
                cards.remove(card[i]);
            } else {
                i--;
            }
        }
    }

}
