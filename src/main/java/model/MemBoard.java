package model;

/**
 * The type Mem board.
 */
public class MemBoard {
    private int width;
    private int height;
    private MemBoardSquares[][] boardSquares = new MemBoardSquares[width][height];

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets width.
     *
     * @param width the width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get board squares mem board squares [ ] [ ].
     *
     * @return the mem board squares [ ] [ ]
     */
    public MemBoardSquares[][] getBoardSquares() {
        return boardSquares;
    }

    /**
     * Sets board squares.
     *
     * @param boardSquares the board squares
     */
    public void setBoardSquares(MemBoardSquares[][] boardSquares) {
        this.boardSquares = boardSquares;
    }
}