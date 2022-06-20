package com.company;

import java.util.ArrayList;

public class Account {

    private String username;
    private QueueWithPointer<Verlauf> verlauf;

    Account(String username, ArrayList<String[]> verlauf) {
        this.username = username;
        this.verlauf = stringArrToVerlauf(verlauf);
    }

    Account(String username) {
        this.username = username;
        this.verlauf = new QueueWithPointer<>();
    }

    private QueueWithPointer<Verlauf> stringArrToVerlauf(ArrayList<String[]> v) {
        // Todo noch nicht fertig
        return new QueueWithPointer<Verlauf>();
    }
}
