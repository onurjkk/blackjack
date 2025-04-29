package com.blackjack.controller;


import com.blackjack.BlackjackGame;
import com.blackjack.Carta;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

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
    public Label lblPlayer;
    @FXML
    public Label lblDealer;
    @FXML
    public Button btnRigioca;
    @FXML
    public Button btnEsci;
    @FXML
    public Label lblFine;
    @FXML
    public Pane paneFine;


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
            int ris = blackjack.dealerTurno();
            switch (ris){
                case BlackjackGame.PERSO -> {
                    if (blackjack.getDealerValore() > 21) {
                        finePartita("Hai pareggiato!");
                    } else {
                        finePartita("Hai Vinto!");
                    }
                }
                case BlackjackGame.PAREGGIO -> finePartita("Hai pareggiato!");
                case BlackjackGame.VINTO -> finePartita("Vince Banco!");
            }
            //finePartita("Hai sballato!");
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
            case BlackjackGame.PERSO -> finePartita("Hai perso!");
            case BlackjackGame.PAREGGIO -> finePartita("Hai pareggiato!"); 
            case BlackjackGame.VINTO -> finePartita("Hai vinto!");
        }

        btnCarta.setDisable(true);
        btnPassa.setDisable(true);

    }

    @FXML
    public void rigioca(MouseEvent mouseEvent) {
        blackjack.reset();

        paneFine.setDisable(true);
        paneFine.setOpacity(0);

        btnCarta.setDisable(false);
        btnPassa.setDisable(false);

        updateUI();
    }

    @FXML
    public void esci(MouseEvent mouseEvent) {
        System.exit(0);
    }


    private void finePartita(String message) {
        paneFine.setDisable(false);
        paneFine.setOpacity(1);
        lblFine.setText(message);
    }

    private ImageView getCartaImage(Carta carta) {

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
