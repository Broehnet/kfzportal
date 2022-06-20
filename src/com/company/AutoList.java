package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AutoList {

    final static ArrayList<String[]> list = getAutoListFromCSV();
    final static int size = list.size();
    static ArrayList<String[]> currentListModel;
    static ArrayList<String[]> currentListTrim;

    private static ArrayList<String[]> getAutoListFromCSV() {
        String path = "src/com/company/cardbf.csv";
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

    public static Auto getAutoArrayFromInput(String marke) {
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
            else if (comp < 0) bottom = c + 1;
            else if (comp > 0) top = c - 1;
        }
        return new Auto(new String[]{});

    }

    public static ArrayList<String> distinct(ArrayList<String[]> lst, int index) {
        ArrayList<String> result = new ArrayList<>();
        String current;
        for (String[] strings : lst) {
            current = strings[index];
            if (!included(result, current)) result.add(current);

        }
        return result;
    }

    public static boolean included(ArrayList<String> lst, String input) {
        if (lst.size() == 0) return false;
        for (String s : lst) {
            if (s.equals(input)) return true;
        }
        return false;
    }

    public static ArrayList<String[]> slice(ArrayList<String[]> lst, int place, String input) {
        ArrayList<String[]> result = new ArrayList<>();
        int index = binarySearch(lst, place, input);
        int bottom = getBottomTop(lst, place, input, index, true);
        int top = getBottomTop(lst, place, input, index, false);
        for (int i = bottom; i <= top; i++) result.add(lst.get(i));
        return result;
    }

    public static int getBottomTop(ArrayList<String[]> lst, int place, String input, int index, boolean isBottom) {
        int c = 1;
        if (isBottom) c = -1;
        while (true) {
            if (index < 0) return 0;
            else if (index == lst.size()) return lst.size() - 1;
            else if (!lst.get(index)[place].equals(input)) break;
            index += c;
        }
        return index - c;
    }

    public static int binarySearch(ArrayList<String[]> lst, int place, String input) {
        int bottom = 0;
        int top = lst.size() - 1;
        int c;
        String str;
        int comp;
        while (top >= bottom) {
            c = bottom + ((top - bottom)  / 2);
            str = lst.get(c)[place];
            comp = str.compareTo(input);
            if (comp == 0) return c;
            else if (comp < 0) bottom = c + 1;
            else if (comp > 0) top = c - 1;

        }
        return -1;

    }


}
