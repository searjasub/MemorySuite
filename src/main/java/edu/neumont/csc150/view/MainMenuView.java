package edu.neumont.csc150.view;

import edu.neumont.csc150.controller.MainMenuController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainMenuView {

    public Button memoryGame;
    public Button SequenceGame;
    public Button NumberGame;
    public HBox hbox;
    public BorderPane borderPane;
    public Label topLabel;

    private MainMenuController controller;
    private Stage stage;

    public void setController(MainMenuController controller) {
        this.controller = controller;
    }

    public void init(Stage stage) {
        this.stage = stage;

        this.stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("icon2.png"))));
        this.stage.setTitle("Memory Suite");
        this.stage.centerOnScreen();
        this.stage.setMinWidth(900);
        this.stage.setMinHeight(800);
        this.stage.show();

        topLabel.setFont(Font.font("HP Simplified Light", FontWeight.BOLD, 14));
        hbox.setSpacing(40);
        hbox.setPadding(new Insets(50, 0, 0, 0));
    }

    public void onMemoryGameClicked(ActionEvent actionEvent) throws IOException {
        System.out.println("Memory Game Clicked");
        Stage newStage = (Stage) memoryGame.getScene().getWindow();
        stage.setScene(newStage.getScene());
        MemoryGameView memoryGameView = new MemoryGameView();
        memoryGameView.init(stage);
    }


    public void onSequenceGameClicked(ActionEvent actionEvent) {

    }

    public void onNumberGameClicked(ActionEvent actionEvent) {

    }

    public void onSave(ActionEvent actionEvent) {

    }

    public void onLoad(ActionEvent actionEvent) {

    }

    public void onRestart(ActionEvent actionEvent) {

    }

    public void onExit(ActionEvent actionEvent) {
        this.stage.close();
    }

    public void onAbout(ActionEvent actionEvent) {
        Alert popup = new Alert(Alert.AlertType.NONE, "Memory Suite by Felix, Jeff and Sear.", ButtonType.CLOSE);
        popup.setTitle("About Memory Suite");
        popup.show();
    }

}
