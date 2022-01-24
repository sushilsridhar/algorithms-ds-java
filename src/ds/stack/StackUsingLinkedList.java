package ds.stack;

/*
    Stack implementation using Linked List

    - insert at head
    - delete from head

    push, pop
    Time complexity: O(1)
 */
public class StackUsingLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node head;

    public static void push(int element) {

        Node node = new Node(element);
        node.next = head;
        head = node;
    }

    public static void pop() {
        head = head.next;
    }

    public static void main(String[] args) {

        push(1);
        push(2);
        push(3);
        pop();
        push(4);
        pop();
        push(5);
        push(6);
        pop();
        push(7);

        Node pointer = head;
        while(pointer != null) {
            System.out.print(pointer.data+" ");
            pointer = pointer.next;
        }

    }
}
