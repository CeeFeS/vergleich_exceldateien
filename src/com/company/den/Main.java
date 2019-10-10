package com.company.den;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String datei1 = args[0];
        String datei2 = args[1];
        if (datei1.equals("-help")) {
            System.out.println("java -jar vergleich_exceldateien [datei-1.csv] [datei-2.csv]");
        } else {
            CSV csv1 = new CSV();
            ArrayList<Zeile> csv_allezeilen = csv1.einlesen(datei1);

            CSV csv2 = new CSV();
            ArrayList<Zeile> csv2_allezeilen = csv2.einlesen(datei2);


            Scanner scanner = new Scanner(System.in);

            Vergleich vergleich = new Vergleich(csv_allezeilen, csv2_allezeilen);

            System.out.println("Welche Spalte soll bei: " + datei1 + " verglichen werden?");
            String csv1_spalte1 = scanner.nextLine();
            System.out.println(csv1_spalte1 + " Spalte soll bei: " + datei2 + " mit ... verglichen werden: ");
            String csv2_spalte1 = scanner.nextLine();

            System.out.println("Welche Spalte soll bei: " + datei1 + " verglichen werden?");
            String csv1_spalte2 = scanner.nextLine();
            System.out.println(csv1_spalte2 + " Spalte soll bei: " + datei2 + " mit ... verglichen werden: ");
            String csv2_spalte2 = scanner.nextLine();

            System.out.println("Welche Spalte soll bei: " + datei1 + " verglichen werden?");
            String csv1_spalte3 = scanner.nextLine();
            System.out.println(csv1_spalte3 + " Spalte soll bei: " + datei2 + " mit ... verglichen werden: ");
            String csv2_spalte3 = scanner.nextLine();

            System.out.println("Welche Spalte soll bei: " + datei1 + " verglichen werden?");
            String csv1_spalte4 = scanner.nextLine();
            System.out.println(csv1_spalte4 + " Spalte soll bei: " + datei2 + " mit ... verglichen werden: ");
            String csv2_spalte4 = scanner.nextLine();

            int[] auswertung = vergleich.ausführen(csv1_spalte1, csv1_spalte2, csv1_spalte3, csv1_spalte4, csv2_spalte1, csv2_spalte2, csv2_spalte3, csv2_spalte4);

            System.out.println("Anzahl der Zeilen für\t" + csv1 + "\t" + auswertung[4]);
            System.out.println("Anzahl der Zeilen für\t" + csv2 + "\t" + auswertung[5]);
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Anzahl der richtigen Spalte\t" + csv1_spalte1 + "\t" + auswertung[0]);
            System.out.println("Anzahl der richtigen Spalte\t" + csv1_spalte2 + "\t" + auswertung[1]);
            System.out.println("Anzahl der richtigen Spalte\t" + csv1_spalte3 + "\t" + auswertung[2]);
            System.out.println("Anzahl der richtigen Spalte\t" + csv1_spalte4 + "\t" + auswertung[3]);
        }
    }
}
