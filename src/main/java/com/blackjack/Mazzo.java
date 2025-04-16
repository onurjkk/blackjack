package com.blackjack;

import java.util.ArrayList;

public class Mazzo {

    static ArrayList<Carta> carte;

    public Mazzo() {
        carte = new ArrayList<>(52);
        for(int i=1; i<=13; i++) {
            carte.add(new Carta(i,"cuori"));
            carte.add(new Carta(i,"fiori"));
            carte.add(new Carta(i,"picche"));
            carte.add(new Carta(i,"quadri"));
        }
    }

}
