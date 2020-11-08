package gr.aueb.ds.project1.queue;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Node<T> implements Iterable<T> {

    private Node<T> previous;
    private Node<T> next;
    private T item;

    public Node() {
    }

    public Node(T item) {
        this.item = item;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
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
