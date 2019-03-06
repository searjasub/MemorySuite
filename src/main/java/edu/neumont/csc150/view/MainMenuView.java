package edu.neumont.csc150.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
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
        viewNavigator.showMemoryGameSettings();
    }

    public void onSequenceGameClicked() throws IOException {
        viewNavigator.showSequenceGameSettings();
    }

    public void onNumberGameClicked() {
        viewNavigator.showNumberGameSettings();
    }

    public void onLoad() {

    }

    public void onExit() {
        viewNavigator.closeStage();
    }

    public void onAbout() {
        viewNavigator.aboutAlert();
    }

    private void registerViewNavigator(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
    }

}
