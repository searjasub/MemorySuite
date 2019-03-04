package edu.neumont.csc150.view;

import edu.neumont.csc150.controller.MemoryGameController;
import edu.neumont.csc150.model.CardTypes;
import edu.neumont.csc150.model.Coordinate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryGameView {

    public GridPane board;
    //TODO HERE IS WHERE VIEW TALKS TO CONTROLLER :D
    private MemoryGameController controller;
    private ViewNavigator viewNavigator;
    private Map<Coordinate, Label> positionOfCards = new HashMap<>();

    void init(ViewNavigator viewNavigator, MemoryGameController controller) {
        registerViewNavigator(viewNavigator);
        registerController(controller);
        drawBoard();
        this.controller.initPlayer("Sear");
    }

    private void drawBoard() {
        Image image = new Image("/images/card_back_2.png");
        for (int r = 0; r < controller.getGridSize(); r++) {
            for (int c = 0; c < controller.getGridSize(); c++) {
                Label card = new Label();
                card.addEventFilter(MouseEvent.MOUSE_CLICKED,handleFirstClick());
                ImageView finalImage = new ImageView(image);
                finalImage.setFitHeight(100);
                finalImage.setFitWidth(71.508379888268156424581005586592);
                //finalImage.setFitWidth(100);
                card.setGraphic(finalImage);
                card.setId(r + "x" +c);
                board.add(card, r, c);
                positionOfCards.put(new Coordinate(r,c), card);
                System.out.println("Created card on "+ r + "x" + c);
            }
        }
    }

    private EventHandler<MouseEvent> handleFirstClick() {
        return event -> {
            Coordinate coordinate = mouseEventHelper(event);
            if (event.getButton() == MouseButton.PRIMARY){
                System.out.println(coordinate);
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
