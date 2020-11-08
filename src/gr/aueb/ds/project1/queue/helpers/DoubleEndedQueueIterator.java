package gr.aueb.ds.project1.queue.helpers;

import java.util.Iterator;

public class DoubleEndedQueueIterator<T> implements Iterator<T> {

    private Node<T> first;
    private Node<T> currentNode;

    public DoubleEndedQueueIterator(Node<T> node) {
        this.first = node;
        this.currentNode = node;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public T next() {
        T currentItem = this.currentNode.getItem();
        this.currentNode = this.currentNode.getNext();

        return currentItem;
    }

}
