package com.company.den;

import sun.security.krb5.internal.CredentialsUtil;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Vergleich {
    private ArrayList<Zeile> csv1_zeilen, csv2_zeilen;
    private ArrayList<String> falschezeilen;

    public Vergleich(ArrayList<Zeile> csv1_zeilen, ArrayList<Zeile> csv2_zeilen) {
        this.csv1_zeilen = csv1_zeilen;
        this.csv2_zeilen = csv2_zeilen;
    }

    public int[] ausführen(String csv1_spalte1, String csv1_spalte2, String csv1_spalte3,
                           String csv2_spalte1, String csv2_spalte2, String csv2_spalte3) {
        falschezeilen = new ArrayList<String>();

        int spalte1 = 0;
        int spalte2 = 0;
        int spalte3 = 0;
        int spalte4 = 0;

        int gesamt_richtig = 0;

        for (Zeile zeile1 : csv1_zeilen) {
            for (Zeile zeile2 : csv2_zeilen) {

                boolean spalte1_richtig = zeile1.getZelle(Integer.parseInt(csv1_spalte1)).trim().equals(zeile2.getZelle(Integer.parseInt(csv2_spalte1)).trim());
                boolean spalte2_richtig = zeile1.getZelle(Integer.parseInt(csv1_spalte2)).trim().equals(zeile2.getZelle(Integer.parseInt(csv2_spalte2)).trim());
                boolean spalte3_richtig = zeile1.getZelle(Integer.parseInt(csv1_spalte3)).trim().equals(zeile2.getZelle(Integer.parseInt(csv2_spalte3)).trim());


                if (zeile1 != null && zeile2 != null) {
                    if (spalte1_richtig) {
                        spalte1++;
                        if (spalte2_richtig) {
                            spalte2++;
                            if (spalte3_richtig) {
                                spalte3++;

                            }
                        }
                    }
                }

                if (zeile1 != null && zeile2 != null) {
                    if (spalte1_richtig && spalte2_richtig && spalte3_richtig) {
                        gesamt_richtig++;
                    } else if (spalte1_richtig && spalte2_richtig && !(spalte3_richtig)) {
                        falschezeilen.add(zeile1.getZelle(Integer.parseInt(csv1_spalte1)) + " " + zeile1.getZelle(Integer.parseInt(csv1_spalte2)) + " " + zeile1.getZelle(Integer.parseInt(csv1_spalte3)));
                        falschezeilen.add(zeile2.getZelle(Integer.parseInt(csv2_spalte1)) + " " + zeile2.getZelle(Integer.parseInt(csv2_spalte2)) + " " + zeile2.getZelle(Integer.parseInt(csv2_spalte3)));
                    } else if (spalte1_richtig && !(spalte2_richtig) && spalte3_richtig) {
                        falschezeilen.add(zeile1.getZelle(Integer.parseInt(csv1_spalte1)) + " " + zeile1.getZelle(Integer.parseInt(csv1_spalte2)) + " " + zeile1.getZelle(Integer.parseInt(csv1_spalte3)));
                        falschezeilen.add(zeile2.getZelle(Integer.parseInt(csv2_spalte1)) + " " + zeile2.getZelle(Integer.parseInt(csv2_spalte2)) + " " + zeile2.getZelle(Integer.parseInt(csv2_spalte3)));
                    } else if (!(spalte1_richtig) && spalte2_richtig && spalte3_richtig) {
                        falschezeilen.add(zeile1.getZelle(Integer.parseInt(csv1_spalte1)) + " " + zeile1.getZelle(Integer.parseInt(csv1_spalte2)) + " " + zeile1.getZelle(Integer.parseInt(csv1_spalte3)));
                        falschezeilen.add(zeile2.getZelle(Integer.parseInt(csv2_spalte1)) + " " + zeile2.getZelle(Integer.parseInt(csv2_spalte2)) + " " + zeile2.getZelle(Integer.parseInt(csv2_spalte3)));
                    }
                }

            }
        }
        int[] auswertung = {spalte1, spalte2, spalte3, spalte4, gesamt_richtig};
        return auswertung;
    }


    public ArrayList<String> getFalschezeilen() {
        return falschezeilen;
    }
}
