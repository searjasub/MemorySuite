package view;

import controller.MemoryGameController;
import javafx.stage.Stage;

public class MemoryGameView{

    private MemoryGameController controller;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void registerController(MemoryGameController memoryGameController) {
        controller = memoryGameController;
    }

    public void init() {
        stage.setTitle("Memory Suite");
        stage.centerOnScreen();
        stage.setMinWidth(900);
        stage.setMinHeight(800);
        stage.show();
    }

    public int getWidth() {
        return 0;
    }


}
