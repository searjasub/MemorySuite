package view;

import controller.MainViewController;
import controller.MemoryController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * The type Main view.
 */
public class MainView {

    private static MemoryGameView memGameView;
    private static MemoryController memoryController;

    private static MainMenuView menuView;
    private static MainViewController menuController;

    private static Stage stage;
    private static Parent root, memGame;

    /**
     * Show main menu.
     */
    public static void showMainMenu(){
        stage.setScene(new Scene(root));
        menuController.run();
    }

    /**
     * Show memory game.
     */
    public static void showMemoryGame() {
        Scene scene = new Scene(memGame);
        stage.setScene(scene);
        memoryController.run();
    }

    /**
     * Show number game.
     */
    public static void showNumberGame(){
        stage.setScene(new Scene(root));
    }

    /**
     * Show sequence game.
     */
    public static void showSequenceGame(){
        stage.setScene(new Scene(root));
    }

    /**
     * Initialize all the FXML files and load them to their respective views
     *
     * @param s the s
     */
    public void init(Stage s) throws IOException {
        stage = s;
        URL locationMainMenu = this.getClass().getClassLoader().getResource("MainMenuView.fxml");
        FXMLLoader loaderMainMenu = new FXMLLoader(locationMainMenu);

        URL locationMemGame = this.getClass().getClassLoader().getResource("MemoryGameView.fxml");
        FXMLLoader loaderMemGame = new FXMLLoader(locationMemGame);

        root = loaderMainMenu.load();
        menuView = loaderMainMenu.getController();

        memGame = loaderMemGame.load();
        memGameView = loaderMemGame.getController();
        memGameView.setStage(s);
        memoryController = new MemoryController(memGameView);


    }
}
