package edu.neumont.csc150.view;

import edu.neumont.csc150.controller.MemoryGameController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class MemoryGameView {

    public Button cardSettings;
    public Button timerSettings;
    public Button gridSizeSettings;
    public Button startGameBtn;
    public Button openSavedGame;
    public Button returnBtn;
    public HBox bottomPart;

    private ViewNavigator viewNavigator;

    private MemoryGameController controller = new MemoryGameController();

    public void init(ViewNavigator viewNavigator) {
        bottomPart.setSpacing(640);
        bottomPart.setPadding(new Insets(400, 20, 0, 20));
        registerViewNavigator(viewNavigator);
    }

    public void returnBtn() throws Exception {
        viewNavigator.showMainMenu();
    }

    public void onSave() {

    }

    public void onLoad() {

    }

    public void onRestart() {

    }

    public void onExit() throws IOException {
        viewNavigator.showMainMenu();
    }

    public void onAbout() {

    }

    public void showSaveScreen() {

    }

    private void registerViewNavigator(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
    }

}
