package gr.aueb.ds.project1.queue;

import java.util.Iterator;

public class DoubleEndedQueueIterator<T> implements Iterator<T> {

    private Node<T> first;

    public DoubleEndedQueueIterator(Node<T> node) {
        this.first = node;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

}
