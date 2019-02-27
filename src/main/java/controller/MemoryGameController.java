package controller;

import model.MemBoard;
import model.Player;
import view.MemoryGameView;

public class MemoryGameController {

    private MemoryGameView view;
    Player player = new Player();

    private MemBoard board = new MemBoard();

    public MemoryGameController(MemoryGameView ui) {
        view = ui;
        view.registerController(this);
    }

    public void run() {
        view.init();
        board.setWidth(view.getWidth());
    }
}
