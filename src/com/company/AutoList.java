package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class AutoList {

    final static ArrayList<String[]> list = getAutoListFromCSV();
    final static int size = list.size();

    private static ArrayList<String[]> getAutoListFromCSV() {
        String path = "src/com/company/cardb.csv";
        String row;
        ArrayList<String[]> a = new ArrayList<>();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(path));
            csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                a.add(data);
            }
            csvReader.close();
            return a;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Auto getAutoFromInput(String marke) {
        // binary search
        // TODO Funktioniert noch nicht so richtig, fehler liegt bei den Indezes
        int bottom = 0;
        int top = size - 1;
        System.out.println(size);
        int c;
        int comp;
        String[] autoArr;
        while (top >= bottom) {
            c = bottom + ((top - bottom)  / 2);
            autoArr = list.get(c);
            comp = (autoArr[1] + autoArr[2]).toLowerCase().compareTo(marke.toLowerCase());
            if (comp == 0) return new Auto(autoArr);
            else if (comp < 0) {
                bottom = c + 1;
            }
            else if (comp > 0) {
                top = c - 1;
            }
            System.out.println("a" + Integer.toString(c) + "   " + Integer.toString(bottom));
        }
        System.out.println("neger");
        return new Auto(new String[]{});

    }


}
