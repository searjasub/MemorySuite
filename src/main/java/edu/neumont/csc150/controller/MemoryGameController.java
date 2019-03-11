package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.CardType;
import edu.neumont.csc150.model.MemBoard;
import edu.neumont.csc150.model.Player;
import edu.neumont.csc150.view.MemoryGameSettingsView;
import edu.neumont.csc150.view.MemoryGameView;
import edu.neumont.csc150.view.ViewNavigator;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MemoryGameController  {

    private MemoryGameView view;
    private MemoryGameSettingsView settings;
    private ViewNavigator viewNavigator;
    private int timer;
    private int gridHeight;
    private int gridWidth;
    private Player player = new Player();
    private MemBoard board;
    private CardType[] cards;

    public MemoryGameController(MemoryGameSettingsView settings) {
        this.settings = settings;
    }

    public MemoryGameController(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
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
        cards = getCards();
        if (board.getHeight() == 3) {
            fourByThree(cards);
        } else if (board.getHeight() == 4) {
            sixByFour(cards);
        } else {
            eightByFive(cards);
        }
        board.shuffleCards();
    }

    private CardType[] getCards() {
        Random rng = new Random();
        List<CardType> cards = new ArrayList<>(Arrays.asList(CardType.values()));
        cards.remove(CardType.DEFAULT);
        CardType[] used = new CardType[40];
        for (int i = 0; i < used.length; i++) {
            CardType c = cards.get(rng.nextInt(cards.size()));
            used[i] = c;
            used[i++] = c;
            cards.remove(c);
        }
        return used;
    }

    private void fourByThree(CardType[] cards) {
        for (int x = 0; x < board.getHeight(); x++) {
            for (int y = 0; y < board.getWidth(); y++) {
                if (x == 0 && (y == 0 || y == 1)) {
                    board.setBoardSquare(x, y, cards[0]);
                } else if (x == 0 && (y == 2 || y == 3)) {
                    board.setBoardSquare(x, y, cards[2]);
                } else if (x == 1 && (y == 0 || y == 1)) {
                    board.setBoardSquare(x, y, cards[4]);
                } else if (x == 1 && (y == 2 || y == 3)) {
                    board.setBoardSquare(x, y, cards[6]);
                } else if (x == 2 && (y == 0 || y == 1)) {
                    board.setBoardSquare(x, y, cards[8]);
                } else if (x == 2 && (y == 2 || y == 3)) {
                    board.setBoardSquare(x, y, cards[10]);
                }
            }
        }
    }

    private void sixByFour(CardType[] cards) {
        fourByThree(cards);
        for (int x = 0; x <= board.getHeight(); x++) {
            for (int y = 0; y <= board.getWidth(); y++) {
                if (x == 0 && (y == 4 || y == 5)) {
                    board.setBoardSquare(x, y, cards[12]);
                } else if (x == 1 && (y == 4 || y == 5)) {
                    board.setBoardSquare(x, y, cards[14]);
                } else if (x == 2 && (y == 4 || y == 5)) {
                    board.setBoardSquare(x, y, cards[16]);
                } else if (x == 3 && (y == 0 || y == 1)) {
                    board.setBoardSquare(x, y, cards[18]);
                } else if (x == 3 && (y == 2 || y == 3)) {
                    board.setBoardSquare(x, y, cards[20]);
                } else if (x == 3 && (y == 4 || y == 5)) {
                    board.setBoardSquare(x, y, cards[22]);
                }
            }
        }
    }

    private void eightByFive(CardType[] cards) {
        sixByFour(cards);
        for (int x = 0; x <= board.getHeight(); x++) {
            for (int y = 0; y <= board.getWidth(); y++) {
                if (x == 0 && (y == 6 || y == 7)) {
                    board.setBoardSquare(x, y, cards[24]);
                } else if (x == 1 && (y == 6 || y == 7)) {
                    board.setBoardSquare(x, y, cards[26]);
                } else if (x == 2 && (y == 6 || y == 7)) {
                    board.setBoardSquare(x, y, cards[28]);
                } else if (x == 3 && (y == 6 || y == 7)) {
                    board.setBoardSquare(x, y, cards[30]);
                } else if (x == 4 && (y == 0 || y == 1)) {
                    board.setBoardSquare(x, y, cards[32]);
                } else if (x == 4 && (y == 2 || y == 3)) {
                    board.setBoardSquare(x, y, cards[34]);
                } else if (x == 4 && (y == 4 || y == 5)) {
                    board.setBoardSquare(x, y, cards[36]);
                } else if (x == 4 && (y == 6 || y == 7)) {
                    board.setBoardSquare(x, y, cards[38]);
                }
            }
        }
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
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

    public void setScore(int amount) {
        player.setScore(amount);
    }

    public Player getPlayer() {
        return player;
    }

    public void switchController(MemoryGameView viewController) {
        this.view = viewController;
    }
}

