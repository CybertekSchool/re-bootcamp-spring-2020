package day5_Collections;

import java.util.PriorityQueue;


public class QueueEx {

    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();

        System.out.println(queue.peek());
        // if we use queue.element() -> gives exception
        queue.add("java");
        queue.offer("a");
       // queue.add(null);
        // queue.offer(null);

        System.out.println(queue.element());
        System.out.println(queue.remove());

        System.out.println(queue);



    }
}
