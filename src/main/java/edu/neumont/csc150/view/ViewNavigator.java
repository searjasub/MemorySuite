package edu.neumont.csc150.view;

import edu.neumont.csc150.controller.ViewNavigatorController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ViewNavigator {

    private static ViewNavigator instance;
    private ViewNavigatorController controller;

    private Stage stage;
    private Scene mainMenuScene;
    private Scene memoryGameScene;
    private Scene numberGameScene;
    private Scene sequenceGameScene;

    public ViewNavigator() {
        setInstance(this);
    }

    public static ViewNavigator getInstance() {
        return instance;
    }

    public static void setInstance(ViewNavigator instance) {
        ViewNavigator.instance = instance;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void registerController(ViewNavigatorController viewNavigatorController) {
        this.controller = viewNavigatorController;
    }

    public void init() throws IOException {
        this.stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("icon2.png"))));
        this.stage.setTitle("Memory Suite");
        this.stage.centerOnScreen();
        this.stage.setResizable(false);
        this.stage.setWidth(900);
        this.stage.setHeight(800);
        showMainMenu();
    }

    public void showMainMenu() throws IOException {
        initMainMenu();
        this.stage.setScene(mainMenuScene);
        this.stage.show();
    }

    public void showMemoryGame() throws IOException {
        initMemoryGame();
        this.stage.setScene(memoryGameScene);
        this.stage.show();
    }

    private void initMainMenu() throws IOException {
        //URL location = getClass().getResource("MainMenuView.fxml");
        FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("MainMenuView.fxml"));
        Parent root = loader.load();
        MainMenuView viewController = loader.getController();
        viewController.init(this);
        mainMenuScene = new Scene(root);

    }

    private void initMemoryGame() throws IOException {

        FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("MemoryGameView.fxml"));
        Parent root = loader.load();
        memoryGameScene = new Scene(root);

    }


}
