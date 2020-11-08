package gr.aueb.ds.project1.queue;

import java.util.Iterator;

public class Node<T> {

    private Node<T> previous;
    private Node<T> next;
    private T item;

    public Node() {
        this(null);
    }

    public Node(T item) {
        this(null, null, item);
    }

    public Node(Node<T> previous, Node<T> next, T item) {
        this.previous = previous;
        this.next = next;
        this.item = item;
    }

    // Setters & Getters
    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getItem() {
        return this.item;
    }
}
