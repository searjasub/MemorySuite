package edu.neumont.csc150.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemBoard {
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



    public void setBoardSquares(MemBoardSquare[][] boardSquares) {
        this.boardSquares = boardSquares;
    }

    public void setBoardSquare(int x, int y, CardType cardType) {
        boardSquares[y][x].setType(cardType);
    }

    public CardType getCard(int x, int y) {
        return boardSquares[y][x].getType();
    }

    public void shuffleCards(){
        List<MemBoardSquare> cards = new ArrayList<>();

        for (int h = 0; h < this.getHeight()-1; h++) {
            for (int w = 0; w < this.getWidth()-1; w++) {
                cards.add(this.getBoardSquare(this.getBoardSquares(),h,w));
            }
            Collections.shuffle(cards);
            MemBoardSquare[] singleArray = (MemBoardSquare[]) cards.toArray();
            int index1 = 0, index2 = 0;
            for (MemBoardSquare memBoardSquare : singleArray) {
                boardSquares[height][width] = memBoardSquare;
                index2++;
                if (index2 == width && index1 < height) {
                    index1++;
                    index2 = 0;
                }
            }
        }

    }
}
