package com.company;

import java.io.*;
import java.util.ArrayList;

public class AccountManager {

    private static final String path = Constants.pathToAccountFile;
    private static String message;

    public static String getMessage() {
        String m = message;
        message = "";
        return m;
    }

    public static Account logIn(String username, String password) throws IOException {
        if (username.length() == 0) {
            message = "Username eingeben!";
            return null;
        }
        else if (!accountExists(username) || username.charAt(0) == '-') {
            message = "Konto existiert nicht";
            return null;
        }
        else if (password.length() == 0) {
            message = "Passwort eingeben!";
            return null;
        }
        else if (wrongPassword(username, password)) {
            message = "Falsches Passwort";
            return null;
        }
        else {
            message = "Willkommen " + username;
            return new Account(username, getVerlauf(username));
        }
    }

    public static Account register(String username, String password) throws IOException {
        if (username.length() == 0) {
            message = "Username eingeben!";
            return null;
        }
        else if (password.length() == 0) {
            message = "Passwort eingeben!";
            return null;
        }
        else if (username.charAt(0) == '-') {
            message = "Username darf nicht mit '-' beginnen";
            return null;
        }
        else if (!checkUserName(username)) {
            message = "Username darf kein ',' beinhalten";
            return null;
        }
        else if (accountExists(username)) {
            message = "Konto existiert bereits";
            return null;
        }
        else if (password.length() < 8) {
            message = "Passwort muss mindestens 8 Zeichen lang sein";
            return null;
        }
        else {
            writeAccountToFile(username, password);
            message = "Erfolgreich registriert und eingeloggt";
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
            if (row.charAt(0) != '-' || row.length() > 0) names.add(row.split(",")[0]);
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
                if (password.equals(arr[1])) return false;
                else return true;
            }
        }
        csvReader.close();
        return false;
    }

    public static ArrayList<String[]> getVerlauf(String username) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        ArrayList<String[]> verlauf = new ArrayList<>();
        while ((row = csvReader.readLine()) != null) {
            if (username.equals(row.split(",")[0])) {
                row = csvReader.readLine();
                String withoutFirstTwo;
                while(row.charAt(0) == '-') {
                    withoutFirstTwo = row.substring(2);
                    verlauf.add(withoutFirstTwo.split(","));
                    row = csvReader.readLine();
                }
                break;
            }
        }
        csvReader.close();
        return verlauf;
    }

    private static boolean checkUserName(String username) {
        for (int i = 0; i < username.length(); i++) if (username.charAt(i) == ',') return false;
        return  true;
    }

    public static void writeAccountToFile(String username, String password) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(path, true));
        writer.write(username + ",");
        writer.write(password + "\n");
        writer.close();
    }

    public static void writeKostenToFile(Kosten kosten, String username) throws IOException {
        ArrayList<String> lst = getAllLinesFromFile();
        int index = getIndexOfUsernameInFile(username, lst) + 1;
        lst.add(index, getLine(kosten));
        PrintWriter writer = new PrintWriter(path);
        for (String line : lst) writer.write(line+"\n");
        writer.close();
    }

    private static String getLine(Kosten kosten) {
        String c = ",";
        Auto auto = kosten.getAuto();
        StringBuilder str = new StringBuilder();
        str.append("-," + kosten.getDauer() + c);
        str.append(kosten.getKmProJahr() + c);
        str.append(kosten.getGesamtkosten() + c);
        str.append(auto.getMarke() + c);
        str.append(auto.getModel() + c);
        str.append(auto.getTrim() + c);
        str.append(auto.getCylinder_layout() + c);
        str.append(auto.getNumberOfCylinders() + c);
        str.append(auto.getEngine_type() + c);
        str.append(auto.getMixed_fuel() + c);
        str.append(auto.getCity_fuel() + c);
        str.append(auto.getHighway_fuel());
        return str.toString();
    }

    private static ArrayList<String> getAllLinesFromFile() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        ArrayList<String> lines = new ArrayList<>();
        String row;
        while ((row = csvReader.readLine()) != null) {
            lines.add(row);
        }
        csvReader.close();
        return lines;
    }

    private static int getIndexOfUsernameInFile(String username, ArrayList<String> lst) {
        for (int i = 0; i < lst.size(); i++) if (username.equals(lst.get(i).split(",")[0])) return i;
        return -1;
    }

}
