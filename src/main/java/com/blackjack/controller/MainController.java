package com.blackjack.controller;


import com.blackjack.Carta;
import com.blackjack.Mazzo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class MainController {

    @FXML
    public HBox playerHBox;
    @FXML
    public HBox dealerHBox;
    @FXML
    public Button btnCarta;
    @FXML
    public Button btnPassa;
    @FXML
    public Button btnSplit;


    public void addCarta(Carta carta, HBox box) {

        ImageView image = new ImageView(new Image(getClass().getResource("/com/blackjack/carte/"+ carta.getSeme() +"/"+ carta.getValore() +".png").toExternalForm()));
        image.setFitHeight(150);
        image.setFitWidth(100);
        image.setPreserveRatio(true);
        image.setPickOnBounds(true);
        
        box.getChildren().add(image);
    }


    @FXML
    public void initialize() {

        Mazzo mazzo = new Mazzo();
        
        System.out.println(mazzo);

        addCarta(mazzo.getCarta(), playerHBox);
        addCarta(mazzo.getCarta(), playerHBox);

        System.out.println(mazzo);

        btnCarta.setDisable(false);
        btnPassa.setDisable(false);
    }   

    @FXML
    public void carta(MouseEvent mouseEvent) {
        System.out.println("carta");
    }

    @FXML 
    public void passa(MouseEvent mouseEvent) {
        System.out.println("passa");
    }

    @FXML
    public void split(MouseEvent mouseEvent) {
        System.out.println("split");
    }


}
