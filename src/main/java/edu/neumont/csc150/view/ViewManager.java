package edu.neumont.csc150.view;

import edu.neumont.csc150.controller.MainMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ViewManager {

    private static MainMenuView mainMenuView;
    private static MainMenuController mainMenuController;

    private static Parent root;
    private static Stage stage;

    public static void showMainMenu() {
        stage.setScene(new Scene(root));
        mainMenuController.run();
    }

    public void init(Stage primaryStage) throws IOException {
        stage = primaryStage;
        URL locationMainMenu = this.getClass().getClassLoader().getResource("MainMenuView.fxml");
        FXMLLoader loaderMainMenu = new FXMLLoader(locationMainMenu);

        root = loaderMainMenu.load();
        //mainMenuView.setStage(stage);
        //mainMenuController = new MainMenuController(mainMenuView);
    }
}
