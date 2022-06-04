package ds.stack;

/*
    Stack implementation using Linked List

    - insert at head
    - delete from head


    Time complexity:

    push - O(1)
    pop  - O(1)
    peek - O(1)
    size - O(1)

 */
public class Stack<E> {

    private Node<E> head;
    private int size = 0;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    public E push(E element) {
        Node<E> node = new Node<E>(element);
        node.next = head;
        head = node;
        size++;

        return element;
    }

    public E pop() {
        if(head != null) {
            E poppedEle = head.data;

            head = head.next;
            size--;

            return poppedEle;
        }
        return null;
    }

    public E peek() {
        if(head != null) {
            return head.data;
        }
        return null;
    }

    public int size() {
        return size;
    }
}
