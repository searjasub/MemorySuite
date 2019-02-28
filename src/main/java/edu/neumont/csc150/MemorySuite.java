package edu.neumont.csc150;

import edu.neumont.csc150.controller.MainMenuController;
import edu.neumont.csc150.view.MainMenuView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MemorySuite extends Application {

    public static void main(String[] args) {
        Application.launch(MemorySuite.class, args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("MainMenuView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        MainMenuView viewController = loader.getController();
        MainMenuController controller = new MainMenuController();
        controller.setView(viewController);
        viewController.setController(controller);
        viewController.init(primaryStage);
    }
}
