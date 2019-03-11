package edu.neumont.csc150;

import edu.neumont.csc150.controller.ViewNavigatorController;
import edu.neumont.csc150.view.ViewNavigator;
import javafx.application.Application;
import javafx.stage.Stage;

public class MemorySuite extends Application {

    public static void main(String[] args) {
        Application.launch(MemorySuite.class, args);
    }

    public void start(Stage primaryStage) throws Exception {
        ViewNavigator viewNavigator = new ViewNavigator();
        viewNavigator.setStage(primaryStage);
        ViewNavigatorController controller = new ViewNavigatorController(viewNavigator);
        controller.run();
    }
}
