package edu.neumont.csc150.model;

public class MemBoard {
    private int width;
    private int height;
    private MemBoardSquare[][] boardSquares = new MemBoardSquare[width][height];

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

    public void setBoardSquares(MemBoardSquare[][] boardSquares) {
        this.boardSquares = boardSquares;
    }

    public void setBoardSquare(int x, int y, CardTypes cardType){
        this.boardSquares[x][y].setType(cardType);
    }
}