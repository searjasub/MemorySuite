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
    private Player player = new Player();
    private double timer;
    private int gridSize;
    private MemBoard board = new MemBoard();


    public MemoryGameController(MemoryGameView view) {
        this.view = view;
    }

    public MemoryGameController(MemoryGameSettingsView settings) {
        this.settings = settings;
    }

    public MemoryGameController(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
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

    public void setBoard(MemBoard board) {
        this.board = board;
    }

    public MemBoard getBoard() {
        return board;
    }

    public void init() {
        initBoardSquares();
    }

    private void initBoardSquares() {
        CardTypes c = CardTypes.ONE;
        if (board.getHeight() == 4 && board.getWidth() == 4) {
            threeByFour(c);
        } else if (board.getHeight() == 6 && board.getWidth() == 6) {
            fiveBySix(c);
        } else {
            sixByEight(c);
        }
    }

    private void threeByFour(CardTypes c) {
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
                }
                board.setBoardSquare(x, y, c);
            }
        }
    }

    private void fiveBySix(CardTypes c) {
        threeByFour(c);
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
                } else if (x == 4 && (y == 0 || y == 1)) {
                    c = CardTypes.THIRTEEN;
                } else if (x == 4 && (y == 2 || y == 3)) {
                    c = CardTypes.FOURTEEN;
                } else if (x == 4 && (y == 4 || y == 5)) {
                    c = CardTypes.FIFTEEN;
                }
                board.setBoardSquare(x, y, c);
            }
        }
    }

    private void sixByEight(CardTypes c) {
        fiveBySix(c);
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
                }else if (x == 5 && (y == 0 || y == 1)) {
                    c = CardTypes.TWENTYONE;
                } else if (x == 5 && (y == 2 || y == 3)) {
                    c = CardTypes.TWENTYTWO;
                } else if (x == 5 && (y == 4 || y == 5)) {
                    c = CardTypes.TWENTYTHREE;
                } else if (x == 5 && (y == 6 || y == 7)) {
                    c = CardTypes.TWENTYFOUR;
                }
                board.setBoardSquare(x, y, c);
            }
        }
    }

    public void switchController(MemoryGameView viewController) {
        this.view = viewController;
    }
}
