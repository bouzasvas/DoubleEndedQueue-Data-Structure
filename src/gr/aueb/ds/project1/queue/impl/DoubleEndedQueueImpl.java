package gr.aueb.ds.project1.queue.impl;

import gr.aueb.ds.project1.queue.helpers.DoubleEndedQueueIterator;
import gr.aueb.ds.project1.queue.helpers.Node;
import gr.aueb.ds.project1.queue.api.DoubleEndedQueue;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleEndedQueueImpl<T> implements DoubleEndedQueue<T>, Iterable<T> {

    private static final String EXCEPTION_MSG = "Queue is empty!";

    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void addFirst(T item) {
        Node<T> currentFirst = this.first;
        Node<T> node = new Node<>(null, currentFirst, item);

        swapNodes(true, node);

        // First Item of Queue
        if (isEmpty()) swapNodes(false, node);

        // Always increase size of Queue
        this.size++;
    }

    @Override
    public T removeFirst() throws NoSuchElementException {
        if (first == null && isEmpty()) throw new NoSuchElementException(EXCEPTION_MSG);

        T firstItem = first.getItem();
        swapNodes(true, first.getNext());
        this.size--;

        if (isEmpty()) deleteAllElements();

        return firstItem;
    }

    @Override
    public void addLast(T item) {
        Node<T> currentLast = this.last;
        Node<T> node = new Node<>(currentLast, null, item);
        // Swap Last Node
        swapNodes(false, node);

        // First Item of Queue
        if (isEmpty()) {
            // Swap First Node
            swapNodes(true, node);
        }

        // Always increase size of Queue
        this.size++;
    }

    @Override
    public T removeLast() throws NoSuchElementException {
        if (this.last == null && isEmpty()) throw new NoSuchElementException(EXCEPTION_MSG);

        Node<T> currentLast = this.last;
        swapNodes(false, currentLast.getPrevious());
        this.size--;

        if (isEmpty()) deleteAllElements();

        return currentLast.getItem();
    }

    @Override
    public T getFirst() {
        return this.first.getItem();
    }

    @Override
    public T getLast() {
        return this.last.getItem();
    }

    @Override
    public void printQueue(PrintStream stream) {
        for (T item : this) {
            stream.println(item);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    // Helper Functions
    private void swapNodes(boolean firstNode, Node<T> node) {
        if (firstNode) {
            // Update previous item of Current First Item in order to point to new First
            if (!isEmpty()) this.first.setPrevious(node);

            if (node != null) node.setPrevious(null);
            this.first = node;

            if (isEmpty()) this.first.setNext(node);
        }
        else {
            // Update next item of Current Last Item in order to point to new Last
            if (!isEmpty()) this.last.setNext(node);

            if (node != null) node.setNext(null);
            this.last = node;
        }
    }

    private void deleteAllElements() {
        this.first = null;
        this.last = null;
    }

    // Iterator
    @Override
    public Iterator<T> iterator() {
        return new DoubleEndedQueueIterator<>(this.first);
    }
}
