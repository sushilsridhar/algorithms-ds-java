package ds.queue;

import ds.interfaces.Queue;
import ds.list.LinkedList;

/*
    Test Queue implementation methods in LinkedList class
 */
public class Test {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<11; i++) {
            queue.add(i);
        }

        System.out.println(queue.peek());
        System.out.println(queue.poll());

        System.out.println(queue.peek());
        System.out.println(queue.poll());

        System.out.println(queue.peek());

        for(int i=0; i<5; i++) {
            queue.poll();
        }

        System.out.println(queue.peek());
        System.out.println(queue.add(1));
        System.out.println(queue.peek());

    }
}
