package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.CardTypes;
import edu.neumont.csc150.model.MemBoard;
import edu.neumont.csc150.model.Player;
import edu.neumont.csc150.view.MemoryGameSettingsView;
import edu.neumont.csc150.view.MemoryGameView;
import edu.neumont.csc150.view.ViewNavigator;

public class MemoryGameController {

    private MemoryGameView view;
    private MemoryGameSettingsView settings;
    private ViewNavigator viewNavigator;
    private double timer;
    private int gridHeight;
    private int gridWidth;
    private Player player = new Player();
    private MemBoard board;

    public MemoryGameController(MemoryGameSettingsView settings) {
        this.settings = settings;
    }

    public MemoryGameController(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
    }

    public void initPlayer(String playerName) {
        player.setName(playerName);
    }

    public void setBoard(MemBoard board) {
        this.board = board;
    }

    public MemBoard getBoard() {
        return board;
    }

    public void init() {
        board = new MemBoard();
        board.setHeight(gridHeight);
        board.setWidth(gridWidth);
        board.initBoard();
        initBoardSquares();
    }

    private void initBoardSquares() {
        if (board.getHeight() == 3) {
            fourByThree();
        } else if (board.getHeight() == 4) {
            sixByFour();
        } else {
            eightByFive();
        }
    }

    private void fourByThree() {

        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                if (x == 0 && (y == 0 || y == 1)) {
                    board.setBoardSquare(x, y, CardTypes.ONE);
                } else if (x == 0 && (y == 2 || y == 3)) {
                    board.setBoardSquare(x, y, CardTypes.TWO);
                } else if (x == 1 && (y == 0 || y == 1)) {
                    board.setBoardSquare(x, y, CardTypes.THREE);
                } else if (x == 1 && (y == 2 || y == 3)) {
                    board.setBoardSquare(x, y, CardTypes.FOUR);
                } else if (x == 2 && (y == 0 || y == 1)) {
                    board.setBoardSquare(x, y, CardTypes.FIVE);
                } else if (x == 2 && (y == 2 || y == 3)) {
                    board.setBoardSquare(x, y, CardTypes.SIX);
                }
            }
        }
    }

    private void sixByFour() {
        fourByThree();
        CardTypes c;
        for (int x = 0; x <= board.getWidth(); x++) {
            for (int y = 0; y <= board.getHeight(); y++) {
                if (x == 0 && (y == 4 || y == 5)) {
                    c = CardTypes.SEVEN;
                } else if (x == 1 && (y == 4 || y == 5)) {
                    c = CardTypes.EIGHT;
                } else if (x == 2 && (y == 4 || y == 5)) {
                    c = CardTypes.NINE;
                }else if (x == 3 && (y == 0 || y == 1)) {
                    c = CardTypes.TEN;
                } else if (x == 3 && (y == 2 || y == 3)) {
                    c = CardTypes.ELEVEN;
                } else if (x == 3 && (y == 4 || y == 5)) {
                    c = CardTypes.TWELVE;
                }
//                else if (x == 4 && (y == 0 || y == 1)) {
//                    c = CardTypes.THIRTEEN;
//                } else if (x == 4 && (y == 2 || y == 3)) {
//                    c = CardTypes.FOURTEEN;
//                } else if (x == 4 && (y == 4 || y == 5)) {
//                    c = CardTypes.FIFTEEN;
//                }
                //board.setBoardSquare(x, y, c);
            }
        }
    }

    private void eightByFive() {
        sixByFour();
        CardTypes c;
        for (int x = 0; x <= board.getWidth(); x++) {
            for (int y = 0; y <= board.getHeight(); y++) {
                if (x == 0 && (y == 6 || y == 7)) {
                    c = CardTypes.SIXTEEN;
                } else if (x == 1 && (y == 6 || y == 7)) {
                    c = CardTypes.SEVENTEEN;
                } else if (x == 2 && (y == 6 || y == 7)) {
                    c = CardTypes.EIGHTEEN;
                } else if (x == 3 && (y == 6 || y == 7)) {
                    c = CardTypes.NINETEEN;
                } else if (x == 4 && (y == 6 || y == 7)) {
                    c = CardTypes.TWENTY;
                }
//                else if (x == 5 && (y == 0 || y == 1)) {
//                    c = CardTypes.TWENTYONE;
//                } else if (x == 5 && (y == 2 || y == 3)) {
//                    c = CardTypes.TWENTYTWO;
//                } else if (x == 5 && (y == 4 || y == 5)) {
//                    c = CardTypes.TWENTYTHREE;
//                } else if (x == 5 && (y == 6 || y == 7)) {
//                    c = CardTypes.TWENTYFOUR;
//                }
                //board.setBoardSquare(x, y, c);
            }
        }
    }

    public void setTimer(double timer) {
        this.timer = timer;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public void setGridHeight(int gridHeight) {
        this.gridHeight = gridHeight;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
    }

    public void setLives(int lives) {
        player.setLives(lives);
    }

    public void switchController(MemoryGameView viewController) {
        this.view = viewController;
    }
}
