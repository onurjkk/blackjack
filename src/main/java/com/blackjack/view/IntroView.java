package com.blackjack.view;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;


public class IntroView {

    private static Stage stage;

    public IntroView(Stage stage) {
        IntroView.stage = stage;
    }

    public FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("/com/blackjack/intro.fxml"));
    }

    public static Stage getStage() {return stage;}

}
