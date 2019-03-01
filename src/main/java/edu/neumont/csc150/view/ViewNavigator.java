package edu.neumont.csc150.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ViewNavigator {

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

    void showMemoryGame() throws IOException {
        initMemoryGame();
        this.stage.setScene(memoryGameScene);
        this.stage.setWidth(900);
        this.stage.setHeight(600);
        this.stage.show();
    }

    private void initMemoryGame() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource(""));
        Parent root = loader.load();
        MemoryGameView viewController = loader.getController();
        viewController.init(this);
        memoryGameScene = new Scene(root);

    }

    private void initMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("MainMenuView.fxml"));
        Parent root = loader.load();
        MainMenuView viewController = loader.getController();
        viewController.init(this);
        mainMenuScene = new Scene(root);
    }

    private void initMemoryGameSettings() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("MemoryGameSettingsView.fxml"));

        Parent root = loader.load();
        MemoryGameSettingsView viewController = loader.getController();
        viewController.init(this);
        memoryGameSettingsScene = new Scene(root);

    }

    void closeStage() {
        this.stage.close();
    }



}
