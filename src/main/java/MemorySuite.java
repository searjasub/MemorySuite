import javafx.application.Application;
import javafx.stage.Stage;
import view.MainView;

public class MemorySuite extends Application {

    public static void main(String[] args) {
        Application.launch(MemorySuite.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainView view = new MainView();
        view.init(primaryStage);
        MainView.showMainMenu();
    }
}
