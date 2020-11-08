package gr.aueb.ds.project1.queue;

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class DoubleEndedQueueImpl<T> implements DoubleEndedQueue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void addFirst(T item) {
        // First Item of Queue
        if (isEmpty()) {
            this.size = 1;
            this.first = new Node<>(item);
        }
        else {

        }
    }

    @Override
    public T removeFirst() throws NoSuchElementException {
        if (first == null && isEmpty()) throw new NoSuchElementException("Queue is empty!");

        T firstItem = first.getItem();
        swapNodes(true, first.getNext());
        this.size--;

        return firstItem;
    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public T removeLast() throws NoSuchElementException {
        return null;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void printQueue(PrintStream stream) {

    }

    @Override
    public int size() {
        return this.size;
    }

    // Helper Functions
    private void swapNodes(boolean firstNode, Node<T> node) {
        if (firstNode) {
            node.setPrevious(null);
            this.first = node;
        }
        else {
            node.setNext(null);
            this.last = node;
        }
    }
}
