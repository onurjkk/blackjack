package com.blackjack;

public class Carta {

    private String seme;
    private String rango;
    private int valore;

    public Carta(String seme, String rango ,int valore) {
        this.seme = seme;
        this.rango = rango;
        this.valore = valore;
    }

    public String getSeme() {
        return seme;
    }

    public String getRango() {
        return rango;
    }

    public int getValore() {
        return valore;
    }

    @Override
    public String toString() {
        return "Carta{seme=" + seme + ",rango="+ rango +",valore=" + valore + "}";
    }
}