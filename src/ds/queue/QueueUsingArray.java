package ds.queue;

/*
    Queue implementation using Array

    <--- dequeue 1 2 3 4 5 <--- enqueue

    insert at one end, delete from another end

    Time complexity:
    enqueue(x) - O(1)
    dequeue()  - O(n)
 */
public class QueueUsingArray {

    static int size = 10;
    static int[] queue = new int[size];
    static int frontPointer = 0;
    static int rearPointer = -1;

    public static void enqueue(int element) {

        if(rearPointer <= size-1) {
            rearPointer++;
            queue[rearPointer] = element;
        }
    }

    public static void dequeue() {

        if(rearPointer != -1) {
            for(int i=0; i<rearPointer; i++) {
                queue[i] = queue[i+1];
            }
            queue[rearPointer] = 0;
            rearPointer--;
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

        for(int i=frontPointer; i<=rearPointer; i++) {
            System.out.print(queue[i]+" ");
        }
    }
}
