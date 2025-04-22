package com.blackjack.controller;


import com.blackjack.BlackjackGame;
import com.blackjack.Carta;
import com.blackjack.Mazzo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    public Label lblPlayer;
    @FXML
    public Label lblDealer;

    private BlackjackGame blackjack;


    @FXML
    public void initialize() {

        blackjack = new BlackjackGame();
        blackjack.start();

        updateUI();

        btnCarta.setDisable(false);
        btnPassa.setDisable(false);
    }   

    @FXML
    public void carta(MouseEvent mouseEvent) {

        boolean continuaGioco = blackjack.playerCarta();
        updateUI();

        if(!continuaGioco) {
            System.out.println("hai sballato!");
            btnCarta.setDisable(true);
            btnPassa.setDisable(true);
            updateUI();
        }
    }

    @FXML 
    public void passa(MouseEvent mouseEvent) {
        
        int risultato = blackjack.dealerTurno();

        updateUI();

        switch(risultato) {
            case -1 -> System.out.println("hai perso!");
            case 0 -> System.out.println("hai pareggiato!"); 
            case 1 -> System.out.println("hai vinto");
        }

        btnCarta.setDisable(true);
        btnPassa.setDisable(true);

    }

    @FXML
    public void split(MouseEvent mouseEvent) {
        System.out.println("split");
    }


    public ImageView getCartaImage(Carta carta) {

        ImageView image = new ImageView(new Image(getClass().getResource("/com/blackjack/carte/"+ carta.getSeme() +"/"+ carta.getRango() +".png").toExternalForm()));
        image.setFitHeight(150);
        image.setFitWidth(100);
        image.setPreserveRatio(true);
        image.setPickOnBounds(true);
        
        return image;
    }

    private void updateUI() {
        
        playerHBox.getChildren().clear();
        dealerHBox.getChildren().clear();

        lblPlayer.setText("Player: " + blackjack.getPlayerValore());
        lblDealer.setText("Dealer: " + blackjack.getDealerValore());

        for(Carta carta: blackjack.getPlayerMano()) {
            ImageView image = getCartaImage(carta);
            playerHBox.getChildren().add(image);
        }

        for(Carta carta: blackjack.getDealerMano()) {
            ImageView image = getCartaImage(carta);
            dealerHBox.getChildren().add(image);
        }

    }


}
