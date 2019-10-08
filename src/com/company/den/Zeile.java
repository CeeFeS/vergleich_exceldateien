package com.company.den;

public class Zeile {
    String[] zellen;

    public Zeile(String[] zelle) {
        this.zellen = zellen;
    }

    public String getZelle(int i) {
        return zellen[i];
    }


}
