package edu.neumont.csc150.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MemBoard implements Serializable {
    private int width;
    private int height;
    private MemBoardSquare[][] boardSquares;

    public void initBoard() {
        int w = width;
        int h = height;
        boardSquares = new MemBoardSquare[w][h];
        for (int row = 0; row < w; row++) {
            for (int col = 0; col < h; col++) {
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

    public MemBoardSquare getBoardSquare(MemBoardSquare[][] squares, int h, int w) {
        return squares[h][w];
    }

    public void setBoardSquare(int x, int y, CardType cardType) {
        boardSquares[y][x].setType(cardType);
    }

    public CardType getCard(int x, int y) {
        return boardSquares[y][x].getType();
    }

    public void shuffleCards() {
        List<CardType> cards = new ArrayList<>();
        for (int h = 0; h < this.getHeight(); h++) {
            for (int w = 0; w < this.getWidth(); w++) {
                cards.add(this.getBoardSquare(this.getBoardSquares(), w, h).getType());
                this.setBoardSquare(h, w, CardType.DEFAULT);
            }
        }
        Collections.shuffle(cards);
        CardType[] card = cards.toArray(new CardType[cards.size()]);

        Random rng = new Random();
        for (int i = 0; i < Integer.MAX_VALUE && cards.size() > 0; i++) {
            int r = rng.nextInt(this.getHeight());
            int c = rng.nextInt(this.getWidth());
            MemBoardSquare mbs = this.getBoardSquare(this.getBoardSquares(), c, r);
            if (mbs.getType() == CardType.DEFAULT) {
                mbs.setType(card[i]);
                cards.remove(card[i]);
            } else {
                i--;
            }
        }
    }
}
