package ds.stack;

/*
    Stack implementation using Array

    push, pop
    Time complexity: O(1)
 */
public class StackUsingArray {
    static int size = 100;
    static int[] stack = new int[size];
    static int pointer = -1;

    // Time complexity: O(1)
    public static void push(int element) {
        pointer++;
        if(pointer < size-1) {
            stack[pointer] = element;
        }
    }

    // Time complexity: O(1)
    public static int pop() {
        int ele = -1;
        if(pointer >=0 ) {
            ele = stack[pointer];
            pointer--;
        }
        return ele;
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

        for(int i=0; i<=pointer; i++) {
            System.out.print(stack[i]+" ");
        }
    }
}
