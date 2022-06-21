package com.company;

import java.util.ArrayList;

public class Account {

    private final String username;
    private QueueWithPointer<Verlauf> verlauf;

    Account(String username, ArrayList<String[]> verlauf) {
        this.username = username;
        this.verlauf = stringArrToVerlauf(verlauf);
    }

    Account(String username) {
        this.username = username;
        this.verlauf = new QueueWithPointer<>();
    }

    public String getUsername() {
        return username;
    }

    private QueueWithPointer<Verlauf> stringArrToVerlauf(ArrayList<String[]> v) {
        QueueWithPointer<Verlauf> queue = new QueueWithPointer<>();
        for (String[] s : v) queue.enqueue(new Element<>(null, new Verlauf(s)));
        return queue;
    }

    public QueueWithPointer<Verlauf> getVerlauf() {
        return verlauf;
    }

    public void setVerlauf(ArrayList<String[]> verlauf) {
        this.verlauf = stringArrToVerlauf(verlauf);
    }

}
