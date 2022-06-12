package algo.linkedlist;

/*
    Floyd Cycle Detection Algorithm,

    one pointer moves at speed of 1,
    another pointer moves at speed of 2, (twice the speed of pointer one)
    if there is a cycle, these two pointers will meet some where

    the length from point of meet to cycle start == start of the linked list to the cycle start
 */
public class Floyd_Cycle_Detection_Algo {

    private static boolean fastSlowPointer(ListNode head) {

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while(pointer2.next != null && pointer2.next.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;

            if(pointer1 == pointer2) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();

        System.out.println(fastSlowPointer(head));
    }

    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode createLinkedList() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);



        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n4;

        return head;
    }
}
