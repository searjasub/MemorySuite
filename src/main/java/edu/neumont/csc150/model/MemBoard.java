package edu.neumont.csc150.model;

public class MemBoard {
    private int width;
    private int height;
    private MemBoardSquare[][] boardSquares = new MemBoardSquare[width][height];

    public void initBoard() {
        try {
            for (int row = 0; row < width - 1; row++) {
                for (int col = 0; col < height - 1; col++) {
                    boardSquares[row][col] = new MemBoardSquare();
                    System.out.println("succesfully create instance of in " + row + "x" + col);
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Something went wrong");
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
        this.boardSquares[x][y].setType(cardType);
    }

    public CardTypes getCard(int x, int y) {
        return this.boardSquares[x][y].getType();
    }
}