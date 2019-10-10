package com.company.den;

public class Zeile {
    String[] zellen;

    public Zeile(String[] zellen) {
        this.zellen = zellen;
    }

    public String getZelle(int i) {
        return zellen[i];
    }


}
