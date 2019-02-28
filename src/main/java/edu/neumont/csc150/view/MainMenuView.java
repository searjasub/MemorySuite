package edu.neumont.csc150.view;

import edu.neumont.csc150.controller.MainMenuController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenuView {

    public Button memoryGame;
    public Button SequenceGame;
    public Button NumberGame;
    public HBox hbox;
    public BorderPane borderPane;
    public Text topText;

    private MainMenuController controller;
    private Stage stage;

    public void init(Stage stage, MainMenuController controller){
        this.stage = stage;
        this.controller = controller;

        this.stage.setTitle("Memory Suite");
        this.stage.centerOnScreen();
        this.stage.setMinWidth(900);
        this.stage.setMinHeight(800);
        this.stage.show();

        hbox.setSpacing(50);

    }

    public void onMemoryGameClick(ActionEvent actionEvent) {

    }
}
