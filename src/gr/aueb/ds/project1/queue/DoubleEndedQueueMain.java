package gr.aueb.ds.project1.queue;

import gr.aueb.ds.project1.queue.api.DoubleEndedQueue;
import gr.aueb.ds.project1.queue.impl.DoubleEndedQueueImpl;

public class DoubleEndedQueueMain {

    public static void main(String... args) {
        DoubleEndedQueue<String> stringDoubleEndedQueue = new DoubleEndedQueueImpl<>();

        System.out.println(stringDoubleEndedQueue.isEmpty() + "\n");
        System.out.println(stringDoubleEndedQueue.size() + "\n");

        stringDoubleEndedQueue.addLast("a");
        stringDoubleEndedQueue.addFirst("b");
        stringDoubleEndedQueue.addLast("c");
        stringDoubleEndedQueue.addFirst("d");

        System.out.println(stringDoubleEndedQueue.isEmpty() + "\n");
        System.out.println(stringDoubleEndedQueue.size() + "\n");

        System.out.println("------------------------");
        stringDoubleEndedQueue.printQueue(System.out);
        System.out.println("------------------------");

        String first = stringDoubleEndedQueue.removeFirst();
        System.out.println(first);

        System.out.println("------------------------");
        stringDoubleEndedQueue.printQueue(System.out);
        System.out.println("------------------------");

        String last = stringDoubleEndedQueue.removeLast();
        System.out.println(last);

        System.out.println("------------------------");
        stringDoubleEndedQueue.printQueue(System.out);
        System.out.println("------------------------");

        stringDoubleEndedQueue.removeLast();
//        stringDoubleEndedQueue.removeLast();

        System.out.println("------------------------");
        stringDoubleEndedQueue.printQueue(System.out);
        System.out.println("------------------------");

        stringDoubleEndedQueue.removeFirst();

        System.out.println("------------------------");
        stringDoubleEndedQueue.printQueue(System.out);
        System.out.println("------------------------");

        // Exception
//        stringDoubleEndedQueue.removeLast();
    }

}
