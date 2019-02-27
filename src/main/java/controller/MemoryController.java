package controller;

import model.MemBoard;
import view.MemoryGameView;

public class MemoryController {

    private MemoryGameView view;

    private MemBoard board = new MemBoard();

    public MemoryController(MemoryGameView memGameView) {
        view = memGameView;
        view.registerController(this);
    }

    public void run() {
        view.init();
        board.setWidth(view.getWidth());
    }
}
