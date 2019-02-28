package edu.neumont.csc150.view;

import edu.neumont.csc150.MemorySuite;
import edu.neumont.csc150.controller.MainMenuController;
import edu.neumont.csc150.controller.MemoryGameController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MemoryGameView {

    public Button cardSettings;
    public Button timerSettings;
    public Button gridSizeSettings;
    public Button startGameBtn;
    public Button openSavedGame;
    public Button returnBtn;

    private Stage stage;
    private Scene scene;

    private MemoryGameController controller = new MemoryGameController();

    public void init(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("MemoryGameView.fxml"));
        Parent root = loader.load();
        scene = new Scene(root, 900, 800);
        this.stage = stage;
        this.stage.setTitle("Memory Game");
        this.stage.setScene(scene);
        this.stage.show();
    }

    public void returnBtn(ActionEvent actionEvent) throws Exception {

        ViewNavigator.getInstance().showMainMenu();
    }

    public void onSave(ActionEvent actionEvent) {

    }

    public void onLoad(ActionEvent actionEvent) {

    }

    public void onRestart(ActionEvent actionEvent) {

    }

    public void onExit(ActionEvent actionEvent) throws IOException {
        stage.close();
    }

    public void onAbout(ActionEvent actionEvent) {

    }

    public void showSaveScreen(ActionEvent actionEvent) {

    }
}
