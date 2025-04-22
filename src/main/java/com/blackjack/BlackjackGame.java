package com.blackjack;

import java.util.ArrayList;

public class BlackjackGame {
    
    public static int VINTO = 1;
    public static int PAREGGIO = 0;
    public static int PERSO = -1;

    private Mazzo mazzo;
    private Mano playerMano;
    private Mano dealerMano;

    public void start() {

        mazzo = new Mazzo();
        playerMano = new Mano();
        dealerMano = new Mano();

        playerMano.addCarta(mazzo.getCarta());
        playerMano.addCarta(mazzo.getCarta());

        dealerMano.addCarta(mazzo.getCarta());
        dealerMano.addCarta(mazzo.getCarta());
    }

    public int getPlayerValore() {
        return playerMano.getValore();
    }

    public int getDealerValore() {
        return dealerMano.getValore();
    }

    public ArrayList<Carta> getPlayerMano() {
        return playerMano.getCarte();
    }

    public ArrayList<Carta> getDealerMano() {
        return dealerMano.getCarte();
    }

    public boolean playerCarta() {
        playerMano.addCarta(mazzo.getCarta());
        return playerMano.getValore() <= 21;
    }

    public int dealerTurno() {
        while(dealerMano.getValore() < 17) dealerMano.addCarta(mazzo.getCarta());

        int playerValore = playerMano.getValore();
        int dealerValore = dealerMano.getValore();

        if(dealerValore > 21 || playerValore > dealerValore) return VINTO;
        else if(playerValore == dealerValore) return PAREGGIO;
        else return PERSO;
    }

}
