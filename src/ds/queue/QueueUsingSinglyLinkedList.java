package ds.queue;

/*
     Queue implementation using Linked List

    <--- dequeue 1 2 3 4 5 <--- enqueue

    insert at one end, delete from another end

               Insertion at front - O(1)
    enqueue -  Insertion at tail  - O(1), with tail pointer
    dequeue -  Delete at Front    - O(1)
               Delete at Tail     - O(n), even with tail pointer
 */
public class QueueUsingSinglyLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node head;
    static Node tail;
    static int size = 0;

    public static void enqueue(int element) {

        Node node = new Node(element);

        if(size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            tail.next = node;
            tail = tail.next;
            size++;
        }
    }

    public static void dequeue() {

        if(size != 0) {
            head = head.next;
            size--;
        }
    }

    public static void main(String[] args) {

        enqueue(1);
        enqueue(2);
        dequeue();
        enqueue(3);
        enqueue(4);
        enqueue(5);
        dequeue();
        enqueue(6);
        dequeue();

        Node pointer = head;
        while(pointer != null) {
            System.out.print(pointer.data+" ");
            pointer = pointer.next;
        }
    }
}
