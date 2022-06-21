package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Manager {

    private static Kosten currentKosten = null;
    private static Account currentAccount = null;

    public static void search(int kmProJahr, int dauer, int index) {
        currentKosten = new Kosten(AutoList.currentListTrim.get(index), kmProJahr, dauer);
        if (currentAccount != null) {
            try {
                AccountManager.writeKostenToFile(currentKosten, currentAccount.getUsername());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Kosten getCurrentKosten() {
        return currentKosten;
    }


    public static void setAccount(Account account) {
        currentAccount = account;
    }
}
