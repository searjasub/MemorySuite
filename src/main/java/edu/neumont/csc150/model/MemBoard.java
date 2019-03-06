package edu.neumont.csc150.model;

public class MemBoard {
    private int width;
    private int height;
    private MemBoardSquare[][] boardSquares;

    public void initBoard() {
        int w = width;
        int h = height;
        boardSquares = new MemBoardSquare[h][w];
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
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

    public void setBoardSquares(MemBoardSquare[][] boardSquares) {
        this.boardSquares = boardSquares;
    }

    public void setBoardSquare(int x, int y, CardType cardType) {
        boardSquares[x][y].setType(cardType);
    }

    public CardType getCard(int x, int y) {
        return boardSquares[x][y].getType();
    }
}