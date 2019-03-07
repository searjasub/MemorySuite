package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.CardType;
import edu.neumont.csc150.model.MemBoard;
import edu.neumont.csc150.model.Player;
import edu.neumont.csc150.view.MemoryGameSettingsView;
import edu.neumont.csc150.view.MemoryGameView;
import edu.neumont.csc150.view.ViewNavigator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
    //private Map<Coordinate, CardType> location = new HashMap<>();

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

    private void fourByThree() {
        cards = getCards();

        List<Integer> randomNumber = new ArrayList<>();
        for (int i = 0; i < getCards().length; i++) {
            randomNumber.add(i);
        }

        Random random = new Random();
        int number = random.nextInt(19);
        number += 1;


        for (int r = 0; r < board.getWidth(); r++) {
            for (int c = 0; c < board.getHeight(); c++) {
                if (r == 0 && (c == 0 || c == 1)) {
                    board.setBoardSquare(r, c, cards[0]);
                } else if (r == 0 && (c == 2 || c == 3)) {
                    board.setBoardSquare(r, c, cards[2]);
                } else if (r == 1 && (c == 0 || c == 1)) {
                    board.setBoardSquare(r, c, cards[4]);
                } else if (r == 1 && (c == 2 || c == 3)) {
                    board.setBoardSquare(r, c, cards[6]);
                } else if (r == 2 && (c == 0 || c == 1)) {
                    board.setBoardSquare(r, c, cards[8]);
                } else if (r == 2 && (c == 2 || c == 3)) {
                    board.setBoardSquare(r, c, cards[10]);
                }


//                if (x == 0 && y == 0) {
//                    board.setBoardSquare(x, y, cards[randomNumber.get(number)]);
//                    randomNumber.remove(number);
//                    location.put(new Coordinate(x,y), cards[randomNumber.get(number)]);
//                }
//                else if (x == 0 && y == 1) {
//                    board.setBoardSquare(x, y, cards[randomNumber.get(number)]);
//                    randomNumber.remove(number);
//                   // location.put(new Coordinate(x,y), cards[randomNumber.get(number)]);
//                } else if (x == 0 && y == 2) {
//                    board.setBoardSquare(x, y, cards[randomNumber.get(number)]);
//                    randomNumber.remove(number);
//                   // location.put(new Coordinate(x,y), cards[randomNumber.get(number)]);
//                } else if (x == 0 && y == 3) {
//                    board.setBoardSquare(x, y, cards[randomNumber.get(number)]);
//                    randomNumber.remove(number);
//                    //location.put(new Coordinate(x,y), cards[randomNumber.get(number)]);
//                } else if (x == 1 && y == 0) {
//                    board.setBoardSquare(x, y, cards[randomNumber.get(number)]);
//                    randomNumber.remove(number);
//                    //ocation.put(new Coordinate(x,y), cards[randomNumber.get(number)]);
//                } else if (x == 1 && y == 1) {
//                    board.setBoardSquare(x, y, cards[randomNumber.get(number)]);
//                    randomNumber.remove(number);
//                   // location.put(new Coordinate(x,y), cards[randomNumber.get(number)]);
//                } else if (x == 1 && y == 2) {
//                    board.setBoardSquare(x, y, cards[randomNumber.get(number)]);
//                    randomNumber.remove(number);
//                   // location.put(new Coordinate(x,y), cards[randomNumber.get(number)]);
//                } else if (x == 1 && y == 3) {
//                    board.setBoardSquare(x, y, cards[randomNumber.get(number)]);
//                    randomNumber.remove(number);
//                    //location.put(new Coordinate(x,y), cards[randomNumber.get(number)]);
//                } else if (x == 2 && y == 0) {
//                    board.setBoardSquare(x, y, cards[randomNumber.get(number)]);
//                    randomNumber.remove(number);
//                    //location.put(new Coordinate(x,y), cards[randomNumber.get(number)]);
//                } else if (x == 2 && y == 1) {
//                    board.setBoardSquare(x, y, cards[randomNumber.get(number)]);
//                    randomNumber.remove(number);
//                    //location.put(new Coordinate(x,y), cards[randomNumber.get(number)]);
//                } else if (x == 2 && y == 2) {
//                    board.setBoardSquare(x, y, cards[randomNumber.get(number)]);
//                    randomNumber.remove(number);
//                    //location.put(new Coordinate(x,y), cards[randomNumber.get(number)]);
//                }else if (x == 2 && y == 3) {
//                    board.setBoardSquare(x, y, cards[randomNumber.get(number)]);
//                    randomNumber.remove(number);
//                    //location.put(new Coordinate(x,y), cards[randomNumber.get(number)]);
//                }
//            }
            }
        }
    }

    private void sixByFour() {
        fourByThree();
        for (int r = 0; r <= board.getWidth(); r++) {
            for (int c = 0; c <= board.getHeight(); c++) {
                if (r == 0 && (c == 4 || c == 5)) {
                    board.setBoardSquare(r, c, cards[12]);
                } else if (r == 1 && (c == 4 || c == 5)) {
                    board.setBoardSquare(r, c, cards[14]);
                } else if (r == 2 && (c == 4 || c == 5)) {
                    board.setBoardSquare(r, c, cards[16]);
                } else if (r == 3 && (c == 0 || c == 1)) {
                    board.setBoardSquare(r, c, cards[18]);
                } else if (r == 3 && (c == 2 || c == 3)) {
                    board.setBoardSquare(r, c, cards[20]);
                } else if (r == 3 && (c == 4 || c == 5)) {
                    board.setBoardSquare(r, c, cards[22]);
                }
            }
        }
    }

    private void eightByFive() {
        sixByFour();
        for (int r = 0; r <= board.getWidth(); r++) {
            for (int c = 0; c <= board.getHeight(); c++) {
                if (r == 0 && (c == 6 || c == 7)) {
                    board.setBoardSquare(r, c, cards[24]);
                } else if (r == 1 && (c == 6 || c == 7)) {
                    board.setBoardSquare(r, c, cards[26]);
                } else if (r == 2 && (c == 6 || c == 7)) {
                    board.setBoardSquare(r, c, cards[28]);
                } else if (r == 3 && (c == 6 || c == 7)) {
                    board.setBoardSquare(r, c, cards[30]);
                } else if (r == 4 && (c == 0 || c == 1)) {
                    board.setBoardSquare(r, c, cards[32]);
                } else if (r == 4 && (c == 2 || c == 3)) {
                    board.setBoardSquare(r, c, cards[34]);
                } else if (r == 4 && (c == 4 || c == 5)) {
                    board.setBoardSquare(r, c, cards[36]);
                } else if (r == 4 && (c == 6 || c == 7)) {
                    board.setBoardSquare(r, c, cards[38]);
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
