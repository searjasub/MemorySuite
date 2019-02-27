package controller;

import view.MainMenuView;

public class MainViewController {

    private MainMenuView view;

    public MainViewController(MainMenuView ui){
        this.view = ui;
        this.view.registerController(this);
    }
}
