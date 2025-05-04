package com.blackjack.controller;

import com.blackjack.view.IntroView;
import com.blackjack.view.MainView;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class IntroController {


    @FXML
    public Button btnEsci;
    @FXML
    public Button btnGioca;

    @FXML
    public void esci(MouseEvent mouseEvent) {
        System.exit(0);
        return;
    }

    @FXML
    public void gioca(MouseEvent mouseEvent) throws IOException {
        MainView mainView = new MainView();

        Stage stage = IntroView.getStage();

        Scene scene = new Scene(mainView.getLoader().load(), 831,488);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Blackjack");
        stage.show();
    }
}
