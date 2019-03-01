package edu.neumont.csc150.view;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;

public class MainMenuView {

    public Button memoryGame;
    public Button SequenceGame;
    public Button NumberGame;
    public HBox hbox;
    public BorderPane borderPane;
    public Label topLabel;
    private ViewNavigator viewNavigator;

    void init(ViewNavigator viewNavigator) {
        topLabel.setFont(Font.font("HP Simplified Light", FontWeight.BOLD, 14));
        hbox.setSpacing(40);
        hbox.setPadding(new Insets(50, 0, 0, 0));
        registerViewNavigator(viewNavigator);

    }

    public void onMemoryGameClicked() throws IOException {
        viewNavigator.showMemoryGame();
    }

    public void onSequenceGameClicked() {

    }

    public void onNumberGameClicked() {

    }

    public void onLoad() {

    }

    public void onExit() {
        viewNavigator.closeStage();
    }

    public void onAbout() {
        Alert popup = new Alert(Alert.AlertType.NONE, "Memory Suite by Felix, Jeff and Sear.", ButtonType.CLOSE);
        popup.setTitle("About Memory Suite");
        popup.show();
    }

    private void registerViewNavigator(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
    }

}
