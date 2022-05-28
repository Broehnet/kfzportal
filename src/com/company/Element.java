package com.company;

public class Element<T> {

    private Element<T> next;
    private final T content;

    Element(Element<T> next, T content) {
        this.next = next;
        this.content = content;
    }

    public Element<T> getNext() {
        return this.next;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }

    public T getContent() {
        return this.content;
    }

}
