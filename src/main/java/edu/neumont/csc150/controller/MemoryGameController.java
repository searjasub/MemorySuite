package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.CardTypes;
import edu.neumont.csc150.model.MemBoard;
import edu.neumont.csc150.model.Player;
import edu.neumont.csc150.view.MemoryGameSettingsView;
import edu.neumont.csc150.view.MemoryGameView;

public class MemoryGameController {

    private MemoryGameView view;
    private MemoryGameSettingsView settings;
    private Player player = new Player();
    private double timer;
    private int gridSize;
    private MemBoard board = new MemBoard();


    public MemoryGameController(MemoryGameView view, MemoryGameSettingsView settings) {
        this.settings =settings;
        this.view = view;
    }


    public void setTimer(double timer) {
        this.timer = timer;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public void initPlayer(String playerName) {
        player.setName(playerName);
    }

    public void setLives(int lives) {
        player.setLives(lives);
    }

    public MemBoard getBoard() {
        return board;
    }

    public void init() {
        initBoardSquares();
    }

    private void initBoardSquares() {
        CardTypes c = null;
        if (board.getHeight() == 4 && board.getWidth() == 4) {
            fourByFour(c);
        } else if (board.getHeight() == 6 && board.getWidth() == 6) {
            sixBySix(c);
        } else {
            eightByEight(c);
        }
    }

    private void fourByFour(CardTypes c) {
        for (int x = 0; x <= board.getWidth(); x++) {
            for (int y = 0; y <= board.getHeight(); y++) {
                if (x == 0 && (y == 0 || y == 1)) {
                    c = CardTypes.ONE;
                } else if (x == 0 && (y == 2 || y == 3)) {
                    c = CardTypes.TWO;
                } else if (x == 1 && (y == 0 || y == 1)) {
                    c = CardTypes.THREE;
                } else if (x == 1 && (y == 2 || y == 3)) {
                    c = CardTypes.FOUR;
                } else if (x == 2 && (y == 0 || y == 1)) {
                    c = CardTypes.FIVE;
                } else if (x == 2 && (y == 2 || y == 3)) {
                    c = CardTypes.SIX;
                } else if (x == 3 && (y == 0 || y == 1)) {
                    c = CardTypes.SEVEN;
                } else if (x == 3 && (y == 2 || y == 3)) {
                    c = CardTypes.EIGHT;
                }
                board.setBoardSquare(x, y, c);
            }
        }
    }

    private void sixBySix(CardTypes c) {
        fourByFour(c);
        for (int x = 0; x <= board.getWidth(); x++) {
            for (int y = 0; y <= board.getHeight(); y++) {
                if (x == 0 && (y == 4 || y == 5)) {
                    c = CardTypes.NINE;
                } else if (x == 1 && (y == 4 || y == 5)) {
                    c = CardTypes.TEN;
                } else if (x == 2 && (y == 4 || y == 5)) {
                    c = CardTypes.ELEVEN;
                } else if (x == 3 && (y == 4 || y == 5)) {
                    c = CardTypes.TWELVE;
                } else if (x == 4 && (y == 0 || y == 1)) {
                    c = CardTypes.THIRTEEN;
                } else if (x == 4 && (y == 2 || y == 3)) {
                    c = CardTypes.FOURTEEN;
                } else if (x == 4 && (y == 4 || y == 5)) {
                    c = CardTypes.FIFTEEN;
                } else if (x == 5 && (y == 0 || y == 1)) {
                    c = CardTypes.SIXTEEN;
                } else if (x == 5 && (y == 2 || y == 3)) {
                    c = CardTypes.SEVENTEEN;
                } else if (x == 5 && (y == 4 || y == 5)) {
                    c = CardTypes.EIGHTEEN;
                }
                board.setBoardSquare(x, y, c);
            }
        }
    }

    private void eightByEight(CardTypes c) {
        sixBySix(c);
        for (int x = 0; x <= board.getWidth(); x++) {
            for (int y = 0; y <= board.getHeight(); y++) {
                if (x == 0 && (y == 6 || y == 7)) {
                    c = CardTypes.NINETEEN;
                } else if (x == 1 && (y == 6 || y == 7)) {
                    c = CardTypes.TWENTY;
                } else if (x == 2 && (y == 6 || y == 7)) {
                    c = CardTypes.TWENTYONE;
                } else if (x == 3 && (y == 6 || y == 7)) {
                    c = CardTypes.TWENTYTWO;
                } else if (x == 4 && (y == 6 || y == 7)) {
                    c = CardTypes.TWENTYTHREE;
                } else if (x == 5 && (y == 6 || y == 7)) {
                    c = CardTypes.TWENTYFOUR;
                } else if (x == 6 && (y == 0 || y == 1)) {
                    c = CardTypes.TWENTYFIVE;
                } else if (x == 6 && (y == 2 || y == 3)) {
                    c = CardTypes.TWENTYSIX;
                } else if (x == 6 && (y == 4 || y == 5)) {
                    c = CardTypes.TWENTYSEVEN;
                } else if (x == 6 && (y == 6 || y == 7)) {
                    c = CardTypes.TWENTYEIGHT;
                } else if (x == 7 && (y == 0 || y == 1)) {
                    c = CardTypes.TWENTYNINE;
                } else if (x == 7 && (y == 2 || y == 3)) {
                    c = CardTypes.THIRTY;
                } else if (x == 7 && (y == 4 || y == 5)) {
                    c = CardTypes.THIRTYONE;
                } else if (x == 7 && (y == 6 || y == 7)) {
                    c = CardTypes.THIRTYTWO;
                }
                board.setBoardSquare(x, y, c);
            }
        }
    }

}
