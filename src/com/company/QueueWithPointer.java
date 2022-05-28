package com.company;

public class QueueWithPointer<T> {

    private Element<T> vorne;
    private Element<T> hinten;
    private Element<T> pointer;

    QueueWithPointer() {
        this.vorne = null;
        this.hinten = null;
    }

    public boolean isEmpty() {
        return vorne == null;
    }

    public Element<T> dequeue() {
        Element<T> temp = null;
        if (!isEmpty()) {
            if (pointer == vorne) pointer = vorne.getNext();
            temp = vorne;
            vorne = vorne.getNext();
            if (vorne == null) {
                hinten = null;
                pointer = null;
            }
        }
        return temp;
    }

    public void enqueue(Element<T> e) {
        if (isEmpty()) {
            vorne = e;
            pointer = vorne;
        }
        else {
            hinten.setNext(e);
        }
        hinten = e;
    }

    public Element<T> getPointer() {
        return pointer;
    }

    public void movePointerBack() {
        if (!isEmpty()) {
            if (pointer == hinten) pointer = vorne;
            else pointer = pointer.getNext();
        }
    }

}
