package edu.neumont.csc150.view;

import edu.neumont.csc150.controller.MemoryGameController;
import edu.neumont.csc150.model.Coordinate;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryGameView {

    public GridPane board;
    public Label top1;
    public Label top2;
    public Label top3;
    public Label top4;
    public Label top5;
    public Label score;
    public Label lives;
    private MemoryGameController controller;
    private ViewNavigator viewNavigator;
    private Map<Coordinate, Label> positionOfCards = new HashMap<>();

    void init(ViewNavigator viewNavigator, MemoryGameController controller) throws InterruptedException {
        registerViewNavigator(viewNavigator);
        registerController(controller);
        updateScore();
        updateLives();
        this.controller.initPlayer("Sear");
        this.controller.init();
        showCards();
        hideCards();
    }

    private void hideCards() {
        PauseTransition wait = new PauseTransition(Duration.seconds(controller.getTimer()));
        wait.setOnFinished(event -> drawBoard());
        wait.play();
    }

    private void showCards() {
        for (int x = 0; x < controller.getBoard().getHeight(); x++) {
            for (int y = 0; y < controller.getBoard().getWidth(); y++) {
                Label toShow = new Label();
                toShow.setGraphic(controller.getBoard().getCard(x, y).getImage());
                toShow.setPadding(new Insets(3));
                board.add(toShow, y, x);
                //board.add(positionOfCards.get(new Coordinate(x,y)), y ,x);
            }
        }
    }

    private void updateScore() {
        score.setText("Current Score: " + controller.getPlayer().getScore());
    }

    private void updateLives() {
        lives.setText("Lives: " + controller.getPlayer().getLives());
    }

    private void drawBoard() {
        Image image = new Image("/images/card_back_2.png");
        for (int r = 0; r < controller.getGridHeight(); r++) {
            for (int c = 0; c < controller.getGridWidth(); c++) {
                Label card = new Label();
                card.addEventFilter(MouseEvent.MOUSE_CLICKED, handleFirstClick());
                ImageView finalImage = new ImageView(image);
                finalImage.setFitHeight(100);
                finalImage.setFitWidth(71.508379888268156424581005586592);
                card.setGraphic(finalImage);
                card.setPadding(new Insets(3));
                card.setId(c + "x" + r);
                board.add(card, c, r);
                positionOfCards.put(new Coordinate(c, r), card);
            }
        }
    }

    private EventHandler<MouseEvent> handleFirstClick() {
        return event -> {
            Coordinate coordinate = mouseEventHelper(event);
            if (event.getButton() == MouseButton.PRIMARY) {
                Label toShow = new Label();
                toShow.setGraphic(controller.getBoard().getCard(coordinate.getCol(), coordinate.getRow()).getImage());
                toShow.setPadding(new Insets(3));
                board.add(toShow, coordinate.getRow(), coordinate.getCol());
            }
        };
    }

    private Coordinate mouseEventHelper(MouseEvent event) {
        Label clicked = (Label) event.getSource();
        String cardId = clicked.getId();
        String[] pieces = cardId.split("x");
        return new Coordinate((Integer.parseInt(pieces[0])), Integer.parseInt(pieces[1]));
    }

    private String getPlayerName() {
        Optional<String> name = Optional.empty();
        TextInputDialog dialog = new TextInputDialog("Name");
        dialog.setTitle("Let's get started!");
        dialog.setContentText("Please enter your name");
        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.show();
        return String.valueOf(name);
    }

    private void registerViewNavigator(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
    }

    public void registerController(MemoryGameController controller) {
        this.controller = controller;
    }

    public void onExit() throws IOException {
        viewNavigator.showMainMenu();
    }

    public void onSave(ActionEvent actionEvent) {

    }

    public void onAbout() {
        viewNavigator.aboutAlert();
    }
}
