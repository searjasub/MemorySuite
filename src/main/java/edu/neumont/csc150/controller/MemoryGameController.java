package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.Player;
import edu.neumont.csc150.view.MemoryGameSettingsView;
import edu.neumont.csc150.view.MemoryGameView;

public class MemoryGameController {

    private MemoryGameView view;
    private MemoryGameSettingsView settings;
    private Player player = new Player();
    private double timer;
    private int gridSize;


    public MemoryGameController() {
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
}
