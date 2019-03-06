package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.CardType;
import edu.neumont.csc150.model.MemBoard;
import edu.neumont.csc150.model.Player;
import edu.neumont.csc150.view.MemoryGameSettingsView;
import edu.neumont.csc150.view.MemoryGameView;
import edu.neumont.csc150.view.ViewNavigator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
        CardType[] cards = getCards((board.getWidth()) * (board.getHeight()));
        for (int y = 0; y < board.getHeight(); y++) {
            for (int x = 0; x < board.getWidth(); x++) {
                board.setBoardSquare(x, y, CardType.ONE);


//                if (x == 0 && (y == 0 || y == 1)) {
//                    board.setBoardSquare(x, y, CardType.ONE);
//                } else if (x == 0 && (y == 2 || y == 3)) {
//                    board.setBoardSquare(x, y, CardType.TWO);
//                } else if (x == 1 && (y == 0 || y == 1)) {
//                    board.setBoardSquare(x, y, CardType.THREE);
//                } else if (x == 1 && (y == 2 || y == 3)) {
//                    board.setBoardSquare(x, y, CardType.FOUR);
//                } else if (x == 2 && (y == 0 || y == 1)) {
//                    board.setBoardSquare(x, y, CardType.FIVE);
//                } else if (x == 2 && (y == 2 || y == 3)) {
//                    board.setBoardSquare(x, y, CardType.SIX);
//                }
            }
        }
    }

    private CardType[] getCards(int count) {
        Random rng = new Random();
        ArrayList<CardType> cards = new ArrayList<>(Arrays.asList(CardType.values()));
        CardType[] used = new CardType[count];
        for (int i = 0; i < used.length; i++) {
            CardType c = cards.get(rng.nextInt(cards.size() + 1));
            used[i] = c;
            used[i++] = c;
            cards.remove(c);
        }
        return used;
    }

    private void sixByFour() {
        fourByThree();
        CardType c;
        for (int x = 0; x <= board.getWidth(); x++) {
            for (int y = 0; y <= board.getHeight(); y++) {
                if (x == 0 && (y == 4 || y == 5)) {
                    c = CardType.SEVEN;
                } else if (x == 1 && (y == 4 || y == 5)) {
                    c = CardType.EIGHT;
                } else if (x == 2 && (y == 4 || y == 5)) {
                    c = CardType.NINE;
                } else if (x == 3 && (y == 0 || y == 1)) {
                    c = CardType.TEN;
                } else if (x == 3 && (y == 2 || y == 3)) {
                    c = CardType.ELEVEN;
                } else if (x == 3 && (y == 4 || y == 5)) {
                    c = CardType.TWELVE;
                }
//                else if (x == 4 && (y == 0 || y == 1)) {
//                    c = CardType.THIRTEEN;
//                } else if (x == 4 && (y == 2 || y == 3)) {
//                    c = CardType.FOURTEEN;
//                } else if (x == 4 && (y == 4 || y == 5)) {
//                    c = CardType.FIFTEEN;
//                }
                //board.setBoardSquare(x, y, c);
            }
        }
    }

    private void eightByFive() {
        sixByFour();
        CardType c;
        for (int x = 0; x <= board.getWidth(); x++) {
            for (int y = 0; y <= board.getHeight(); y++) {
                if (x == 0 && (y == 6 || y == 7)) {
                    c = CardType.SIXTEEN;
                } else if (x == 1 && (y == 6 || y == 7)) {
                    c = CardType.SEVENTEEN;
                } else if (x == 2 && (y == 6 || y == 7)) {
                    c = CardType.EIGHTEEN;
                } else if (x == 3 && (y == 6 || y == 7)) {
                    c = CardType.NINETEEN;
                } else if (x == 4 && (y == 6 || y == 7)) {
                    c = CardType.TWENTY;
                }
//                else if (x == 5 && (y == 0 || y == 1)) {
//                    c = CardType.TWENTYONE;
//                } else if (x == 5 && (y == 2 || y == 3)) {
//                    c = CardType.TWENTYTWO;
//                } else if (x == 5 && (y == 4 || y == 5)) {
//                    c = CardType.TWENTYTHREE;
//                } else if (x == 5 && (y == 6 || y == 7)) {
//                    c = CardType.TWENTYFOUR;
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
