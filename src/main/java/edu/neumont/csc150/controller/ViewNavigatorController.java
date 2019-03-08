package edu.neumont.csc150.controller;

import edu.neumont.csc150.view.ViewNavigator;

import java.io.IOException;
import java.io.Serializable;

public class ViewNavigatorController implements Serializable {

    private ViewNavigator viewNavigator;

    public ViewNavigatorController(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
    }

    public void run() throws IOException {
        viewNavigator.init();
    }
}
