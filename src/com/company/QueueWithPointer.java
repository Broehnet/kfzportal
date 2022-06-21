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

    public Element<T> getItem(int index) {
        if (isEmpty()) return null;
        else if (index < 0 || index >= getLength()) return null;
        else if (index == 0) return vorne;
        else if (index == getLength() - 1) return hinten;
        else {
            for (int i = 0; i < index; i++) {
                movePointerBack();
            }
            Element<T> temp = pointer;
            pointer = vorne;
            return temp;
        }
    }

    public int getLength() {
        if (isEmpty()) return 0;
        else {
            int c = 1;
            while (pointer != hinten) {
                movePointerBack();
                c++;
            }
            movePointerBack();
            return c;
        }
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
