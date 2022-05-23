package ds.list;

public class Test {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(100);
        list.addFirst(200);
        list.addLast(500);

        list.remove(3);
        list.remove(4);

        list.add(4, 100);

        list.removeFirst();
        list.removeLast();

        list.set(4, 101);

        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+" --> ");
        }

        System.out.print("null");

        System.out.println("");


        /*
            Test Singly linked list
         */

        SinglyLinkedList.Node n1 = new SinglyLinkedList.Node(1);
        SinglyLinkedList.Node n2 = new SinglyLinkedList.Node(2);
        SinglyLinkedList.Node n3 = new SinglyLinkedList.Node(3);
        SinglyLinkedList.Node n4 = new SinglyLinkedList.Node(4);
        SinglyLinkedList.Node n5 = new SinglyLinkedList.Node(5);
        SinglyLinkedList.Node n6 = new SinglyLinkedList.Node(6);
        SinglyLinkedList.Node n100 = new SinglyLinkedList.Node(100);
        SinglyLinkedList.Node n1000 = new SinglyLinkedList.Node(1000);

        SinglyLinkedList singlyList = new SinglyLinkedList();
        singlyList.add(n1);
        singlyList.add(n2);
        singlyList.add(n3);
        singlyList.add(n4);
        singlyList.add(n6);
        singlyList.addAtFront(n100);
        singlyList.add(n1000);

        singlyList.addAtPos(5, n5);

        singlyList.remove(3);
        singlyList.removeLast();
        singlyList.removeFront();

        SinglyLinkedList.Node pointer = singlyList.head;
        while(pointer != null) {
            System.out.print(pointer.val+" --> ");
            pointer = pointer.next;
        }

        System.out.print("null");

    }
}
