package ds.interfaces;

/*
    Contains methods for implementation of

    - Stack
    - Queue

    Time complexity

    add  - O(1)
    poll - O(1)
    peek - O(1)

    push - O(1)
    pop  - O(1)
 */
public interface Deque<E> extends Queue<E> {

    // *** Queue methods ***

    boolean add(E e);

    E poll();

    E peek();   // common to queue and stack


    // *** Stack methods ***

    void push(E e);

    E pop();




    int size();
}
