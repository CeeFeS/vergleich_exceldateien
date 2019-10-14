package com.company.den;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    String csv1_spalte1;
    String csv1_spalte2;
    String csv1_spalte3;
    String csv1_spalte4;

    String csv2_spalte1;
    String csv2_spalte2;
    String csv2_spalte3;
    String csv2_spalte4;


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
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Welche Spalte soll bei: " + datei1 + " verglichen werden?");
            String csv1_spalte2 = scanner.nextLine();
            System.out.println(csv1_spalte2 + " Spalte soll bei: " + datei2 + " mit ... verglichen werden: ");
            String csv2_spalte2 = scanner.nextLine();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Welche Spalte soll bei: " + datei1 + " verglichen werden?");
            String csv1_spalte3 = scanner.nextLine();
            System.out.println(csv1_spalte3 + " Spalte soll bei: " + datei2 + " mit ... verglichen werden: ");
            String csv2_spalte3 = scanner.nextLine();
            System.out.println("\n\n");
            System.out.println("====================================ERGEBNIS=================================");
            System.out.println("\n");
            int[] auswertung = vergleich.ausführen(csv1_spalte1, csv1_spalte2, csv1_spalte3, csv2_spalte1, csv2_spalte2, csv2_spalte3);

            System.out.println("Anzahl der Zeilen für\t" + datei1 + "\t" + csv_allezeilen.size());
            System.out.println("Anzahl der Zeilen für\t" + datei2 + "\t" + csv2_allezeilen.size());
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Anzahl der richtigen Spalte\t" + csv1_spalte1 + " und " + csv2_spalte1 + "\t--------------->" + auswertung[0]);
            System.out.println("Anzahl der richtigen Spalte\t" + csv1_spalte1 + " und " + csv2_spalte1 + "\t" + csv1_spalte2 + " und " + csv2_spalte2 + "\t--------------->" + auswertung[1]);
            System.out.println("Anzahl der richtigen Spalte\t" + csv1_spalte1 + " und " + csv2_spalte1 + "\t" + csv1_spalte2 + " und " + csv2_spalte2 + "\t" + csv1_spalte3 + " und " + csv2_spalte3 + "\t--------------->" + auswertung[2]);
            System.out.println("-----------------------------------------------------------------------------");


            System.out.println("Anzahl der gesamt richtigen: " + auswertung[4] + "\n");

            System.out.println("Ausführlicher gespeichert unter: " + schreibeLog(vergleich.getFalschezeilen()));
        }
    }

    public static String schreibeLog(ArrayList<String> falschezeilen) {
        File file = new File("log.txt");
        FileWriter log_file;
        try {
            log_file = new FileWriter(file);

            // Initialing BufferedWriter
            BufferedWriter logwrite = new BufferedWriter(log_file);
            logwrite.write("Falsche Zeilen: \n===================================================================\n");
            int j = 0;
            for (String zeile : falschezeilen) {

                if (j % 2 == 0) {
                    logwrite.write("\n\n\n");
                }
                logwrite.write(zeile + "\n");
                j++;
            }

            // Closing BufferWriter to end operation
            logwrite.close();
            System.out.println("Logfile erfolgreich geschrieben!");
        } catch (IOException excpt) {
            excpt.printStackTrace();
        }
        return file.getAbsolutePath();
    }
}
