package controller;

import view.MemoryGameView;

public class MemoryController {

    private MemoryGameView view;

    public MemoryController(MemoryGameView memGameView) {
        view = memGameView;
        view.registerController(this);
    }

    public void run() {
        view.init();
    }
}
