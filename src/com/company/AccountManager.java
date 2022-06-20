package com.company;

import java.io.*;
import java.util.ArrayList;

public class AccountManager {

    private static final String path = "com/company/AccountList.csv";

    public static Account logIn(String username, String password) throws IOException {
        if (!accountExists(username)) {
            // Todo message
            return null;
        }
        else if (wrongPassword(username, password)) {
            // Todo message
            return null;
        }
        else return new Account(username, getVerlauf(username));
    }

    public static Account register(String username, String password) throws IOException {
        if (accountExists(username)) return logIn(username, password);
        else if (!checkUsernamePassword(username, password)) {
            // Todo message
            return null;
        }
        else {
            writeAccountToFile(username, password);
            return new Account(username);
        }
    }

    private static boolean accountExists(String username) throws IOException {
        ArrayList<String> names = getAccountNamesFromFile();
        for (String name : names) if (name.equals(username)) return true;
        return false;

    }

    private static ArrayList<String> getAccountNamesFromFile() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        ArrayList<String> names = new ArrayList<>();
        while((row = csvReader.readLine()) != null) {
            if (row.charAt(0) != '-') names.add(row.split(",")[0]);
        }
        csvReader.close();
        return names;
    }

    private static boolean wrongPassword(String username, String password) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        String[] arr;
        while ((row = csvReader.readLine()) != null) {
            if (row.charAt(0) == '-') continue;
            arr = row.split(",");
            if (username.equals(arr[0])) {
                if (password.equals(arr[1])) return true;
                else return false;
            }
        }
        csvReader.close();
        return false;
    }

    private static ArrayList<String[]> getVerlauf(String username) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        ArrayList<String[]> verlauf = new ArrayList<>();
        while ((row = csvReader.readLine()) != null) {
            if (username.equals(row.split(",")[0])) {
                csvReader.readLine();
                while(row.charAt(0) == '-') verlauf.add(row.substring(2).split(","));
            }
        }
        csvReader.close();
        return verlauf;
    }

    private static boolean checkUsernamePassword(String username, String password) {
        if (username.length() == 0 || username.length() > 16) return false;
        else if (username.charAt(0) == '-' || username.charAt(0) == ',') return false;
        else return password.length() >= 8;
    }

    private static void writeAccountToFile(String username, String password) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(path);
        writer.write(username);
        writer.write(password);
        writer.close();
    }

}
