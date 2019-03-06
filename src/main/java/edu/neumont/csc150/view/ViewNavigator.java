package edu.neumont.csc150.view;

import edu.neumont.csc150.controller.MemoryGameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ViewNavigator {

    private MemoryGameController controller;
    private Stage stage;
    private Scene mainMenuScene;
    private Scene memoryGameSettingsScene;
    private Scene memoryGameScene;
    private Scene numberGameScene;
    private Scene sequenceGameScene;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void init() throws IOException {

        this.stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("images/icon/icon2.png"))));
        this.stage.setTitle("Memory Suite");
        this.stage.centerOnScreen();
        this.stage.setResizable(false);
        this.stage.setWidth(900);
        this.stage.setHeight(800);
        showMainMenu();
    }

    void showMainMenu() throws IOException {
        initMainMenu();

        this.stage.setScene(mainMenuScene);
        this.stage.setWidth(900);
        this.stage.setHeight(800);
        this.stage.show();
    }

    void showMemoryGameSettings() throws IOException {
        initMemoryGameSettings();
        this.stage.setScene(memoryGameSettingsScene);
        this.stage.setWidth(600);
        this.stage.setHeight(450);
        this.stage.show();
    }

    void showMemoryGame() throws IOException, InterruptedException {
        initMemoryGame();
        this.stage.setScene(memoryGameScene);
        if (controller.getGridHeight() == 3) {
            this.stage.setWidth(800);
            this.stage.setHeight(600);
        }
        if (controller.getGridHeight() == 4) {
            this.stage.setWidth(900);
            this.stage.setHeight(700);
        }
        if (controller.getGridHeight() == 5) {
            this.stage.setWidth(1000);
            this.stage.setHeight(800);
        }
        this.stage.show();
    }

    private void initMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("MainMenuView.fxml"));
        Parent root = loader.load();
        MainMenuView viewController = loader.getController();
        viewController.init(this);
        mainMenuScene = new Scene(root);
    }

    private void initMemoryGame() throws IOException, InterruptedException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("MemoryGameView.fxml"));
        Parent root = loader.load();
        MemoryGameView viewController = loader.getController();
        viewController.init(this, controller);

        controller.switchController(viewController);
        memoryGameScene = new Scene(root);

    }

    private void initMemoryGameSettings() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("MemoryGameSettingsView.fxml"));
        Parent root = loader.load();
        MemoryGameSettingsView viewController = loader.getController();
        controller = new MemoryGameController(viewController);
        viewController.init(this, controller);
        memoryGameSettingsScene = new Scene(root);

    }

    void closeStage() {
        this.stage.close();
    }

    void aboutAlert() {
        Alert popup = new Alert(Alert.AlertType.NONE, "Memory Suite by Felix, Jeff and Sear.", ButtonType.CLOSE);
        popup.setTitle("About Memory Suite");
        popup.show();
    }

}
