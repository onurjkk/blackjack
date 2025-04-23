package com.blackjack;

import java.util.ArrayList;

public class Mano {
    
    private ArrayList<Carta> carte = new ArrayList<>();

    public void addCarta(Carta carta) {
        carte.add(carta);
    }

    public int getValore() {

        int valore = 0, assi = 0;

        for(Carta carta: carte) {
            valore += carta.getValore();
            if(carta.getValore() == 11) assi++;
        }

        while(valore > 21 && assi > 0) {
            valore -= 10;
            assi--;
        }

        return valore;
    }

    public ArrayList<Carta> getCarte() {
        return carte;
    }
}
