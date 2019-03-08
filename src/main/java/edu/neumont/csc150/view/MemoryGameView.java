package edu.neumont.csc150.view;

import edu.neumont.csc150.controller.MemoryGameController;
import edu.neumont.csc150.model.CardType;
import edu.neumont.csc150.model.Coordinate;
import edu.neumont.csc150.model.MemBoardSquare;
import edu.neumont.csc150.model.scores.HighscoreManager;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class MemoryGameView implements Serializable {

    //TODO add right click decrease the numbers from settings
    public GridPane board;
    public Label top1;
    public Label score;
    public Label lives;
    public VBox vBoxRightSide;
    HighscoreManager highscoreManager;
    private MemoryGameController controller;
    private ViewNavigator viewNavigator;
    private Map<Coordinate, Label> positionOfCards = new HashMap<>();
    private String[] flippedCards = new String[2];
    private Coordinate coordinate;
    private MemBoardSquare card1;
    private MemBoardSquare card2;
    private int totalScore = 0;
    private int multiplier;
    private int totalLives;
    private int totalCards;
    private List<MemBoardSquare> matched = new ArrayList<>();

    void init(ViewNavigator viewNavigator, MemoryGameController controller) {
        registerViewNavigator(viewNavigator);
        registerController(controller);
        updateScore();
        updateLives();
        this.controller.init();
        vBoxRightSide.setSpacing(10);
        totalLives = controller.getPlayer().getLives();
        lives.setText("Lives: " + totalLives);
        multiplier = controller.getPlayer().getMultiplier();
        highscoreManager = new HighscoreManager();
        top1.setText(highscoreManager.getHighscoreString());
        totalCards = controller.getGridHeight() * controller.getGridWidth();
        showCards();
        hideCards();
    }

    private void hideCards() {
        PauseTransition wait = new PauseTransition(Duration.seconds(controller.getTimer()));
        wait.setOnFinished(event -> drawBoard());
        wait.play();
    }

    private void showCards() {
      for (int r = 0; r < controller.getBoard().getWidth(); r++) {
            for (int c = 0; c < controller.getBoard().getHeight(); c++) {
                MemBoardSquare card = new MemBoardSquare();
                card.setType(controller.getBoard().getCard(c, r));
                File f = new File(card.getType().getUrl());
                Image image = new Image(f.toURI().toString());
                reziseImage(image, card);
                board.add(card, r, c);
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
                MemBoardSquare card = new MemBoardSquare();
                card.addEventFilter(MouseEvent.MOUSE_CLICKED, handleFirstClick());
                reziseImage(image, card);
                card.setId(c + "x" + r);
                card.setType(controller.getBoard().getCard(r, c));
                board.add(card, c, r);
                positionOfCards.put(new Coordinate(c, r), card);
            }
        }
        flippedCards = new String[2];
    }

    private void drawBoardAfterwards() {
        Image backImage = new Image("/images/card_back_2.png");
        for (int r = 0; r < controller.getGridHeight(); r++) {
            for (int c = 0; c < controller.getGridWidth(); c++) {
                MemBoardSquare card = new MemBoardSquare();
                card.setId(c + "x" + r);
                card.setType(controller.getBoard().getCard(r, c));
                card.setMatched(controller.getBoard().getBoardSquare(controller.getBoard().getBoardSquares(), c, r).isMatched());

                File f = new File(card.getType().getUrl());
                if (card.isMatched()) {
                    reziseImage(new Image(f.toURI().toString()), card);
                    matched.add(card);
                } else {
                    card.addEventFilter(MouseEvent.MOUSE_CLICKED, handleFirstClick());
                    reziseImage(backImage, card);
                }
                board.add(card, c, r);
                if (matched.size() == board.getHeight() * board.getWidth() - 1) {
                    int savedScore = totalScore;
                    init(viewNavigator, controller);
                    totalScore = savedScore;
                }
            }
        }
        flippedCards = new String[2];
    }

    private void reziseImage(Image image, Label card) {
        ImageView finalImage = new ImageView(image);
        finalImage.setFitHeight(100);
        finalImage.setFitWidth(71.508379888268156424581005586592);
        card.setGraphic(finalImage);
        card.setPadding(new Insets(3));
    }

    private EventHandler<MouseEvent> handleFirstClick() {
        return event -> {
            coordinate = mouseEventHelper(event);
            if (event.getButton() == MouseButton.PRIMARY && flippedCards[1] == null) {
                MemBoardSquare toShow = new MemBoardSquare();
                File f = new File(controller.getBoard().getCard(coordinate.getCol(), coordinate.getRow()).getUrl());
                Image image = new Image(f.toURI().toString());
                reziseImage(image, toShow);
                board.add(toShow, coordinate.getRow(), coordinate.getCol());

                MemBoardSquare card = (MemBoardSquare) event.getSource();
                String[] pieces = card.getId().split("x");
                card = controller.getBoard().getBoardSquare(controller.getBoard().getBoardSquares(), Integer.parseInt(pieces[0]), Integer.parseInt(pieces[1]));


                if (flippedCards[0] == null) {
                    card1 = card;
                    flippedCards[0] = card.getType().toString();
                } else {
                    card2 = card;
                    flippedCards[1] = card.getType().toString();
                }
                if (flippedCards[1] != null) {
                    if (flippedCards[0].equals(flippedCards[1])) {
                        card1.setMatched(true);
                        card2.setMatched(true);
                        totalCards -= 2;
                        System.out.println(totalCards);
                        totalScore += 100 * multiplier;
                        score.setText("Current Score: " + totalScore);
                        drawBoardAfterwards();
                        if (totalCards == 0) {
                            storeData();
                            resetBoard();
                        }
                    } else {
                        totalLives--;
                        lives.setText("Lives: " + totalLives);
                        if (totalLives == 0) {
                            highscoreManager.addScore(controller.getPlayer().getName(), totalScore);
                            top1.setText(highscoreManager.getHighscoreString());
                            Alert alert = new Alert(Alert.AlertType.NONE);
                            alert.setTitle("Game Over");
                            alert.setContentText("You ran out of lives, better luck next time!");
                            alert.getButtonTypes().clear();
                            ButtonType mainMenuButton = new ButtonType("Main Menu");
                            alert.getButtonTypes().add(mainMenuButton);
                            ButtonType exit = new ButtonType("Exit App");
                            alert.getButtonTypes().add(exit);
                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == mainMenuButton) {
                                try {
                                    viewNavigator.showMainMenu();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else if (result.get() == exit) {
                                viewNavigator.closeStage();
                            }
                        }
                        PauseTransition wait = new PauseTransition(new Duration(500));
                        wait.setOnFinished(e -> drawBoardAfterwards());
                        wait.play();
                    }
                }
            }
        };
    }

    private void resetBoard() {
        this.init(this.viewNavigator, this.controller);
    }

    private void storeData() {
        controller.getPlayer().setLives(totalLives);
        controller.getPlayer().setScore(totalScore);
        controller.getPlayer().setMultiplier(multiplier);
    }

    private Coordinate mouseEventHelper(MouseEvent event) {
        Label clicked = (Label) event.getSource();
        String cardId = clicked.getId();
        String[] pieces = cardId.split("x");
        return new Coordinate((Integer.parseInt(pieces[0])), Integer.parseInt(pieces[1]));
    }

    public void setMultiplier(int multiplier) {
        this.multiplier += multiplier;
    }

    public void resetMultiplier() {
        this.multiplier = 1;
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
