package com.company.den;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if (args[0].equals("-help")) {
            System.out.println("java -jar vergleich_exceldateien [datei-1.csv] [datei-2.csv]");
        } else {
            CSV csv1 = new CSV();
            ArrayList<Zeile> csv_allezeilen = csv1.einlesen(args[0]);

            CSV csv2 = new CSV();
            ArrayList<Zeile> csv2_allezeilen = csv2.einlesen(args[1]);


            Scanner scanner = new Scanner(System.in);

            Vergleich vergleich = new Vergleich(csv_allezeilen, csv2_allezeilen);

            System.out.println("Welche Spalte soll bei: " + args[0] + " verglichen werden?");
            String csv1_spalte1 = scanner.nextLine();
            System.out.println(csv1_spalte1 + " Spalte soll bei: " + args[1] + " mit ... verglichen werden: ");
            String csv2_spalte1 = scanner.nextLine();

            System.out.println("Welche Spalte soll bei: " + args[0] + " verglichen werden?");
            String csv1_spalte2 = scanner.nextLine();
            System.out.println(csv1_spalte2 + " Spalte soll bei: " + args[1] + " mit ... verglichen werden: ");
            String csv2_spalte2 = scanner.nextLine();

            System.out.println("Welche Spalte soll bei: " + args[0] + " verglichen werden?");
            String csv1_spalte3 = scanner.nextLine();
            System.out.println(csv1_spalte3 + " Spalte soll bei: " + args[1] + " mit ... verglichen werden: ");
            String csv2_spalte3 = scanner.nextLine();

            System.out.println("Welche Spalte soll bei: " + args[0] + " verglichen werden?");
            String csv1_spalte4 = scanner.nextLine();
            System.out.println(csv1_spalte4 + " Spalte soll bei: " + args[1] + " mit ... verglichen werden: ");
            String csv2_spalte4 = scanner.nextLine();

            vergleich.ausführen(csv1_spalte1, csv1_spalte2, csv1_spalte3, csv1_spalte4, csv2_spalte1, csv2_spalte2, csv2_spalte3, csv2_spalte4);

        }
    }
}
