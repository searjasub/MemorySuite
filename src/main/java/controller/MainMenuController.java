package controller;

import view.MainMenuView;

public class MainMenuController {

    private MainMenuView view;

    public MainMenuController(MainMenuView ui){
        this.view = ui;
        this.view.registerController(this);
    }

    public void run() {
        view.init();
    }
}
