package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Manager {

    private static Kosten currentKosten = null;
    private static Account currentAccount = null;
    private static QueueWithPointer<Verlauf> verlauf = null;
    private static int currentVerlaufIndex = 0;

    public static void setVerlauf(QueueWithPointer<Verlauf> v) {
        verlauf = v;
    }

    public static QueueWithPointer<Verlauf> getVerlauf() {
        return verlauf;
    }


    public static void setCurrentVerlaufIndex(int i) {
        currentVerlaufIndex = i;
    }

    public static int getCurrentVerlaufIndex() {
        return currentVerlaufIndex;
    }

    public static void search(int kmProJahr, int dauer, int index) {
        currentKosten = new Kosten(AutoList.currentListTrim.get(index), kmProJahr, dauer);
        if (currentAccount != null) {
            try {
                AccountManager.writeKostenToFile(currentKosten, currentAccount.getUsername());
                currentAccount.setVerlauf(AccountManager.getVerlauf(currentAccount.getUsername()));
                verlauf = currentAccount.getVerlauf();
                currentVerlaufIndex = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Kosten getCurrentKosten() {
        return currentKosten;
    }

    public static void setCurrentKosten(Kosten kosten) {
        currentKosten = kosten;
    }


    public static void setAccount(Account account) {
        currentAccount = account;
    }
}
