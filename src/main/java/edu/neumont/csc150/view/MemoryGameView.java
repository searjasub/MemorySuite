package edu.neumont.csc150.view;

import edu.neumont.csc150.controller.MemoryGameController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;

public class MemoryGameView {

    //TODO HERE IS WHERE VIEW TALKS TO CONTROLLER :D
    private MemoryGameController controller;
    private ViewNavigator viewNavigator;

    void init(ViewNavigator viewNavigator) {
        registerViewNavigator(viewNavigator);
        //TODO
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
