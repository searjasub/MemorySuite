package model;

public class MemBoard {
    private int width = 6;
    private int height = 6;
    private MemBoardSquares[][] boardSquares = new MemBoardSquares[width][height];

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

    public MemBoardSquares[][] getBoardSquares() {
        return boardSquares;
    }

    public void setBoardSquares(MemBoardSquares[][] boardSquares) {
        this.boardSquares = boardSquares;
    }
}