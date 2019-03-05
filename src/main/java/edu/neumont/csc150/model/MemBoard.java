package edu.neumont.csc150.model;

public class MemBoard {
    private int width;
    private int height;
    private MemBoardSquare[][] boardSquares;

    public void initBoard() {
        boardSquares = new MemBoardSquare[width][height];
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {
                boardSquares[row][col] = new MemBoardSquare();
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

    public void setBoardSquares(MemBoardSquare[][] boardSquares) {
        this.boardSquares = boardSquares;
    }

    public void setBoardSquare(int x, int y, CardTypes cardType) {
        boardSquares[x][y].setType(cardType);
    }

    public CardTypes getCard(int x, int y) {
        return boardSquares[x][y].getType();
    }
}