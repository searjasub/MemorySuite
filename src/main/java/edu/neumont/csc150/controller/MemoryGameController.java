package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.CardType;
import edu.neumont.csc150.model.Coordinate;
import edu.neumont.csc150.model.MemBoard;
import edu.neumont.csc150.model.Player;
import edu.neumont.csc150.view.MemoryGameSettingsView;
import edu.neumont.csc150.view.MemoryGameView;
import edu.neumont.csc150.view.ViewNavigator;

import java.util.*;

public class MemoryGameController {

    private MemoryGameView view;
    private MemoryGameSettingsView settings;
    private ViewNavigator viewNavigator;
    private int timer;
    private int gridHeight;
    private int gridWidth;
    private Player player = new Player();
    private MemBoard board;
    private CardType[] cards;
    private Map<Coordinate, CardType> location = new HashMap<>();

    public Map<Coordinate, CardType> getLocation() {
        return location;
    }

    public MemoryGameController(MemoryGameSettingsView settings) {
        this.settings = settings;
    }

    public MemoryGameController(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
    }

    public void initPlayer(String playerName) {
        player.setName(playerName);
    }

    public MemBoard getBoard() {
        return board;
    }

    public void setBoard(MemBoard board) {
        this.board = board;
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
        this.getBoard().shuffleCards();
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

    private List<Integer> randomNumber = new ArrayList<>();
    private void fourByThree() {
        cards = getCards();
        for (int i = 0; i < getCards().length; i++) {
            randomNumber.add(i);
        }
        Random random = new Random();
        int number = random.nextInt(19);
        number += 1;

        for (int x = 0; x < board.getHeight(); x++) {
            for (int y = 0; y < board.getWidth(); y++) {
                if (x == 0 && y == 0) {
                    asignRandomCard(number, x, y);
                } else if (x == 0 && y == 1) {
                    asignRandomCard(number, x, y);
                } else if (x == 0 && y == 2) {
                    asignRandomCard(number, x, y);
                } else if (x == 0 && y == 3) {
                    asignRandomCard(number, x, y);
                } else if (x == 1 && y == 0) {
                    asignRandomCard(number, x, y);
                } else if (x == 1 && y == 1) {
                    asignRandomCard(number, x, y);
                } else if (x == 1 && y == 2) {
                    asignRandomCard(number, x, y);
                } else if (x == 1 && y == 3) {
                    asignRandomCard(number, x, y);
                } else if (x == 2 && y == 0) {
                    asignRandomCard(number, x, y);
                } else if (x == 2 && y == 1) {
                    asignRandomCard(number, x, y);
                } else if (x == 2 && y == 2) {
                    asignRandomCard(number, x, y);
                }else if (x == 2 && y == 3) {
                    asignRandomCard(number, x, y);
                }
            }
        }
    }

    private void asignRandomCard(int number, int x, int y) {
        board.setBoardSquare(x, y, cards[randomNumber.get(number)]);
        randomNumber.remove(number);
        location.put(new Coordinate(x,y), cards[randomNumber.get(number)]);
    }

    private void sixByFour() {
        fourByThree();
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

    private void eightByFive() {
        sixByFour();
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
