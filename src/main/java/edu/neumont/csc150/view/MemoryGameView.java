package edu.neumont.csc150.view;

import edu.neumont.csc150.controller.MemoryGameController;

public class MemoryGameView {

    private MemoryGameController controller;
    private ViewNavigator viewNavigator;

    public void init(ViewNavigator viewNavigator) {
        registerViewNavigator(viewNavigator);
    }


    private void registerViewNavigator(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
    }

    public void registerController(MemoryGameController controller) {
        this.controller = controller;
    }
}
