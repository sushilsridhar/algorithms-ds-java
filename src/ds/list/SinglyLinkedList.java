package ds.list;

/*
    Singly Linked list implementation
 */
public class SinglyLinkedList {

    public Node head; // --> original data structure, contains the linked list
    private int size = 0;

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    // tc: O(n)
    public void add(Node newNode) {

        Node pointer = head;
        Node lastElement = null;

        if(pointer != null) {
            while(pointer != null) {
                lastElement = pointer;
                pointer = pointer.next;
            }
            lastElement.next = newNode;
        } else {
            head = newNode;
        }
        size++;
    }

    // tc: O(1)
    public void addAtFront(Node newNode) {
        newNode.next = head;
        head = newNode;
        size++;
    }

    // tc: O(1) or O(n)
    public void addAtLast(Node newNode) {

        // add(newNode); --> tc: O(n)
        // using tail pointer --> tc: O(1)

        /*
            tail.next = newNode;
            tail = newNode;
        */
    }

    // tc: O(n)
    public void addAtPos(int k, Node newNode) {

        if(k>=0 && k<=size) {
            Node pointer = head;

            int counter = 0;
            while(counter < k-1 ) {
                pointer = pointer.next;
                counter++;
            }

            newNode.next = pointer.next;
            pointer.next = newNode;
            size++;
        } else if(k == size+1) {
            add(newNode);
        }
    }

    // tc: O(n)
    public void remove(int k) {

        if(k>0 && k<size) {

            Node pointer = head;

            int counter = 0;
            while(counter < k-1) {
                pointer = pointer.next;
                counter++;
            }
            pointer.next = pointer.next.next;
            size--;
        } else if(k == 0) {
            removeFront();
        } else if(k == size) {
            removeLast();
        }
    }

    // tc: O(1)
    public void removeFront() {
        if(head != null) {
            head = head.next;
            size--;
        }
    }

    // tc: O(n)
    public void removeLast() {
        if(head != null) {
            if(size == 1) {
                removeFront();
                return;
            }
            Node pointer = head;

            while(pointer.next.next != null ) {
                pointer = pointer.next;
            }
            pointer.next = null;
            size--;
        }
    }
}
