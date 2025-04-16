package com.blackjack.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MainController {

    @FXML
    public Label lblProva;

    @FXML
    public void prova(MouseEvent mouseEvent) {
        lblProva.setText("super gay");
    }
}
