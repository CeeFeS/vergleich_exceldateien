package com.company.den;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSV {

    private ArrayList<Zeile> zeilen;

    public ArrayList<Zeile> einlesen(String pfad) {
        String csvFile = pfad;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        ArrayList<String> informationen;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator

                String[] zellen = line.split(cvsSplitBy);
                if (zellen != null) {
                    Zeile zeile = new Zeile(zellen);
                    zeilen.add(zeile);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return zeilen;
    }
}
