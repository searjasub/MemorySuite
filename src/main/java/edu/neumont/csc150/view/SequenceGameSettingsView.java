package edu.neumont.csc150.view;

import edu.neumont.csc150.controller.SequenceGameController;
import javafx.geometry.Insets;

import java.io.IOException;

public class SequenceGameSettingsView {

    private SequenceGameController controller;
    private ViewNavigator viewNavigator;

    private void registerController(SequenceGameController controller) {
        this.controller = controller;
    }

    private void registerViewNavigator(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
    }

    public void init(ViewNavigator viewNavigator, SequenceGameController controller) {
        registerController(controller);

    }

    public void returnBtn() throws Exception {
        viewNavigator.showMainMenu();
    }

    public void onLoad() {

    }

    public void onExit() throws IOException {
        viewNavigator.showMainMenu();
    }

    public void onAbout() {
        viewNavigator.aboutAlert();
    }

}
