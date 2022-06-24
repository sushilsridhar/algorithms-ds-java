package ds.list;

import ds.interfaces.Deque;
import ds.interfaces.List;

import java.util.NoSuchElementException;

/*
    Java linked list is implemented using Doubly Linked List

    Time complexity

    add()         - O(1)
    addFirst()    - O(1)
    addLast()     - O(1)
    add(k, data)  - O(k)

    get(k)        - O(k)
    getFirst()    - O(1)
    getLast()     - O(1)

    remove(k)     - O(k)
    removeFirst() - O(1)
    removeLast()  - O(1)

    set(k, data)  - O(k)

    Note:

    Node class is made static because, the methods inside the Node class does not require access to fields of LinkedList class,
    so by making it static, access to fields of LinkedList class is restricted for Node class

    private int size = 0;

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        void get() {
            System.out.println(size); // Throws error
        }
    }
 */
public class LinkedList<E> implements List<E>, Deque<E> {

    private int size = 0;

    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // --------- PUBLIC METHODS --------- //

    /**  ---------  COMMON TO LINKED LIST AND QUEUE   --------- **/

    @Override
    public boolean add(E e) {   // add to last
        linkToLast(e);
        return true;
    }

    // -------------------------------------------------------- //

    /**  ---------  QUEUE AND STACK IMPLEMENTATION   --------- **/

    @Override
    public E poll() {   // remove from head
        if (first != null)
            return unlinkFirst();
        return null;
    }

    @Override
    public E peek() {
        if(first != null)
            return first.data;
        return null;
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {   // remove from head
        return removeFirst();
    }

    // --------------------------------------------- //

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(E e) {
        linkToFirst(e);
    }

    public void addLast(E e) {
        linkToLast(e);
    }

    public void add(int index, E element) {
        isIndexValid(index);

        if(index == size)
            linkToLast(element);
        else
            linkBefore(element, getNodeAtIndex(index));
    }

    public E get(int index) {
        isIndexValid(index);
        return getNodeAtIndex(index).data;
    }

    public E getFirst() {
        Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.data;
    }

    public E getLast() {
        Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.data;
    }

    public E remove(int index) {
        isIndexValid(index);
        return unLink(getNodeAtIndex(index));
    }

    public E removeFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return unlinkFirst();
    }

    public E removeLast() {
        if(last == null)
            throw new NoSuchElementException();
        return unlinkLast();
    }

    public E set(int index, E element) {
        isIndexValid(index);
        Node<E> x = getNodeAtIndex(index);
        E oldVal = x.data;
        x.data = element;
        return oldVal;
    }

    // --------------------------------- //


    // --------- PRIVATE METHODS --------- //

    private void isIndexValid(int index) {
        if(!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException("index: "+index);
    }

    private Node<E> getNodeAtIndex(int index) {
        /*
            optimization
            - if size is 16 and index is 5, 5 < 16/2, 5 < 8, so iterate from the starting,
            - if size is 16 and index is 12, 12 > 16/2, 12 > 8, so iterate using last pointer
        */

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private void linkBefore(E element, Node<E> nodeAtIndex) {
        Node<E> prevOfNodeAtIndex = nodeAtIndex.prev;
        Node<E> newNode = new Node<>(prevOfNodeAtIndex, element, nodeAtIndex);
        nodeAtIndex.prev = newNode;

        if(prevOfNodeAtIndex == null)  // inserting at index 0
            first = newNode;
        else
            prevOfNodeAtIndex.next = newNode;

        size++;
    }

    private void linkToFirst(E e) {
        Node<E> oldFirst = first;
        Node<E> newNode = new Node<>(null, e, oldFirst);
        first = newNode;

        if(oldFirst == null)
            last = newNode;
        else
            oldFirst.prev = newNode;

        size++;
    }

    private void linkToLast(E e) {
        Node<E> oldLast = last;
        Node<E> newNode = new Node<>(oldLast, e, null);
        last = newNode;

        if(oldLast == null)
            first = newNode;
        else
            oldLast.next = newNode;

        size++;
    }

    private E unLink(Node<E> nodeAtIndex) {

        Node<E> prevNode = nodeAtIndex.prev;
        Node<E> nextNode = nodeAtIndex.next;

        if(prevNode == null) {
            first = nextNode;
        } else {
            prevNode.next = nextNode;
        }

        if(nextNode == null) {
            last = prevNode;
        } else {
            nextNode.prev = prevNode;
            nodeAtIndex.next = null;
        }

        size--;
        return nodeAtIndex.data;
    }

    private E unlinkFirst() {
        E element = first.data;
        Node<E> next = first.next;
        first.data = null;
        first.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    private E unlinkLast() {
        E element = last.data;
        Node<E> prev = last.prev;
        last.data = null;
        last.next = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }
}
