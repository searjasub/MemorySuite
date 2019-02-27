package view;

import controller.MemoryController;
import javafx.stage.Stage;

public class MemoryGameView {

    private MemoryController controller;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void registerController(MemoryController memoryController) {
        controller = memoryController;
    }

    public void init() {

    }

    public int getWidth() {
        return 0;
    }
}
