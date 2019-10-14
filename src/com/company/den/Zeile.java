package com.company.den;

public class Zeile {
    String[] zellen;

    public Zeile(String[] zellen) {
        this.zellen = zellen;
    }

    public String getZelle(int i) {
        return zellen[i];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String zelle : zellen) {
            sb.append(zelle + " ");
        }
        return sb.toString();
    }
}
