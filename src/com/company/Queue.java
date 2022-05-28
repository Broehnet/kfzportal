package com.company;

public class Queue<T> {

    private Element<T> vorne;
    private Element<T> hinten;

    Queue() {
        this.vorne = null;
        this.hinten = null;
    }

    public boolean isEmpty() {
        return vorne == null;
    }

    public Element<T> dequeue() {
        Element<T> temp = null;
        if (!isEmpty()) {
            temp = vorne;
            vorne = vorne.getNext();
            if (vorne == null) hinten = null;
        }
        return temp;
    }

    public void enqueue(Element<T> e) {
        if (isEmpty()) {
            vorne = e;
        }
        else {
            hinten.setNext(e);
        }
        hinten = e;
    }


}
