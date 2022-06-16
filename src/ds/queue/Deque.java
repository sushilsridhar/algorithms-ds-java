package ds.queue;

public interface Deque<E> extends Queue<E> {

    // *** Queue methods ***

    boolean add(E e);

    E poll();

    E peek();


    // *** Stack methods ***
}
