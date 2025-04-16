package com.blackjack.view;

import javafx.fxml.FXMLLoader;

public class MainView {

    public MainView() {}

    public FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("/com/blackjack/main.fxml"));
    }
}