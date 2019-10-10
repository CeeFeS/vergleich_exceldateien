package com.company.den;

import sun.security.krb5.internal.CredentialsUtil;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Vergleich {
    private ArrayList<Zeile> csv1_zeilen, csv2_zeilen;

    public Vergleich(ArrayList<Zeile> csv1_zeilen, ArrayList<Zeile> csv2_zeilen) {
        this.csv1_zeilen = csv1_zeilen;
        this.csv2_zeilen = csv2_zeilen;
    }

    public int[] ausführen(String csv1_spalte1, String csv1_spalte2, String csv1_spalte3, String csv1_spalte4,
                           String csv2_spalte1, String csv2_spalte2, String csv2_spalte3, String csv2_spalte4) {

        int spalte1 = 0;
        int spalte2 = 0;
        int spalte3 = 0;
        int spalte4 = 0;


        for (Zeile zeile1 : csv1_zeilen) {
            for (Zeile zeile2 : csv2_zeilen) {
                if (zeile1 != null && zeile2 != null) {

                    if (zeile1.getZelle(Integer.parseInt(csv1_spalte1)).trim().equals(zeile2.getZelle(Integer.parseInt(csv2_spalte1)).trim())) {
                        spalte1++;
                    }
                    if (zeile1.getZelle(Integer.parseInt(csv1_spalte2)).trim().equals(zeile2.getZelle(Integer.parseInt(csv2_spalte2)).trim())) {
                        spalte2++;
                    }
                    if (zeile1.getZelle(Integer.parseInt(csv1_spalte3)).trim().equals(zeile2.getZelle(Integer.parseInt(csv2_spalte3)).trim())) {
                        spalte3++;
                    }
                    if (zeile1.getZelle(Integer.parseInt(csv1_spalte4)).trim().equals(zeile2.getZelle(Integer.parseInt(csv2_spalte4)).trim())) {
                        spalte4++;
                    }
                }

            }
        }
        int[] auswertung = {spalte1, spalte2, spalte3, spalte4};
        return auswertung;
    }

}
