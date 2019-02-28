package edu.neumont.csc150.view;

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

    private Scene scene;
    private Stage stage = new Stage();

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

    public void onSave(ActionEvent actionEvent) {

    }

    public void onLoad(ActionEvent actionEvent) {

    }

    public void onRestart(ActionEvent actionEvent) {

    }

    public void onExit(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("MainMenuView.fxml"));
        Parent root = loader.load();
        scene = new Scene(root, 900, 800);
    }

    public void onAbout(ActionEvent actionEvent) {

    }

    public void showSaveScreen(ActionEvent actionEvent) {

    }

    public void returnBtn(ActionEvent actionEvent) {
        System.out.println("Return button");
        Stage newStage = (Stage) returnBtn.getScene().getWindow();
        this.stage.setScene(newStage.getScene());
        MainMenuView view = new MainMenuView();
        view.init(this.stage);
    }
}
