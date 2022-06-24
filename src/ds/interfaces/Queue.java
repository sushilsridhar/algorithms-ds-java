package ds.interfaces;

/*
    Time complexity

    add  - O(1)
    poll - O(1)
    peek - O(1)
 */
public interface Queue<E> extends Collection<E> {

    boolean add(E e);

    E poll();

    E peek();

}
