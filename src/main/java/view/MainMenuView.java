package view;

import controller.MainViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainMenuView {

    public Button memoryGame;
    public Button sequenceGame;
    public Button numberGame;
    public HBox hbox;

    private Stage stage;
    private MainViewController controller;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void registerController(MainViewController mainViewController) {
        this.controller = mainViewController;
    }

    public void init() {
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
