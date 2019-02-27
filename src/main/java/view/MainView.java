package view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView {

    private static Parent root;
    private static Stage stage;

    public static void showMemoryGame() {
        stage.setScene(new Scene(root));
    }
}
