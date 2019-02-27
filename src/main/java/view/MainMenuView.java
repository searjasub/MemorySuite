package view;

import controller.MainMenuController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainMenuView {

    public HBox hbox;
    public Button memoryGame;
    public Button sequenceGame;
    public Button numberGame;

    private Stage stage;
    private MainMenuController controller;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void registerController(MainMenuController mainMenuController) {
        this.controller = mainMenuController;
    }

    public void init() {

        stage.setTitle("Memory Suite");
        stage.centerOnScreen();
        stage.setMinWidth(900);
        stage.setMinHeight(800);
        stage.show();


        hbox.setSpacing(30);

        EventHandler<ActionEvent> memoryGame = event -> {
            MainView.showMemoryGame();
        };
        EventHandler<ActionEvent> numberGame = event -> {

        };
        EventHandler<ActionEvent> sequenceGame = event -> {

        };

    }
}
