package edu.neumont.csc150.controller;

import edu.neumont.csc150.view.ViewNavigator;

import java.io.IOException;

public class ViewNavigatorController {

    private ViewNavigator viewNavigator;

    public ViewNavigatorController(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
        this.viewNavigator.registerController(this);
    }

    public void run() throws IOException {
        viewNavigator.init();
    }
}
