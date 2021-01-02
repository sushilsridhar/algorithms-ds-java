package ds.list;

/*
    head is the original data structure that contains the linkedlist

    copy it to pointer, Use pointer for iteration, pointer = pointer.next;

    pointer.next points to same object as head.next,


    pointer.next = some value, alters the value in head also.

 */
public class LinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static Node head; // --> original data structure, contains the linked list

    static void add(Node newNode) { // --> o(n), n --> length of the linked list

        Node pointer = head;

        Node lastElement = null;

        while(pointer != null) {
            lastElement = pointer;
            pointer = pointer.next;
        }

        lastElement.next = newNode;



        Node pointerTwo = head;

        while(pointerTwo != null) {
            System.out.println(pointerTwo.val);
            pointerTwo = pointerTwo.next;
        }

        System.out.println("----------------");
    }

    private static void addAtPos(Node newNode, int pos) { // --> o(n) , n is position to be inserted

        Node pointer = head;
        Node previousElement = null;
        Node nextElement = null;

        int counter = 1;

        while(pointer != null && counter < pos ) {
            previousElement = pointer;
            pointer = pointer.next;
            counter++;
        }

        nextElement = previousElement.next;

        previousElement.next = newNode;

        newNode.next = nextElement;



        Node pointerTwo = head;

        while(pointerTwo != null) {
            System.out.println(pointerTwo.val);
            pointerTwo = pointerTwo.next;
        }

        System.out.println("----------------");
    }

    private static void remove(int pos) { // --> o(n), n is position to be deleted

        Node pointer = head;

        Node prevElement = null;
        Node tbr = null;

        int counter = 1;

        while(pointer != null && counter < pos) {
            prevElement = pointer;
            pointer = pointer.next;
            counter++;
        }

        tbr = prevElement.next;

        prevElement.next = tbr.next;


        Node pointerTwo = head;

        while(pointerTwo != null) {
            System.out.println(pointerTwo.val);
            pointerTwo = pointerTwo.next;
        }

        System.out.println("----------------");
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);

        head = n1;

        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n6 = new Node(6);

        add(n2);
        add(n3);
        add(n4);
        add(n6);

        Node n5 = new Node(5);

        addAtPos(n5, 5);

        remove(3);
    }
}
