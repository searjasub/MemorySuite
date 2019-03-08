package edu.neumont.csc150.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class MainMenuView implements Serializable {

    public Label memoryGame;
    public HBox hbox;
    public BorderPane borderPane;
    private ViewNavigator viewNavigator;

    void init(ViewNavigator viewNavigator) {
        hbox.setSpacing(40);
        hbox.setPadding(new Insets(50, 0, 0, 0));
        registerViewNavigator(viewNavigator);


        memoryGame.setGraphic(new ImageView(new Image(new File("src\\main\\resources\\images\\start.png").toURI().toString())));
        memoryGame.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                onMemoryGameClicked();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void onMemoryGameClicked() throws IOException {
        viewNavigator.showMemoryGameSettings();
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
