package ds.stack;

import java.util.ArrayList;

/*
    Default implementation of Stack class in Java was done by using Vector (dynamic array)

    Stack implementation using Dynamic Array

    - No restrictions on size
    - No overflow check required
    - But underflow can happen

    push, pop
    Time complexity: O(1)

    tc is O(n):
    push is O(n) when array has to resized to fit extra elements

    Inefficient space usage:
    space usage is not efficient
    even when we pop, the array space is not released
 */
public class StackUsingDynamicArray {

    static ArrayList<Integer> stack = new ArrayList<>();
    static int pointer = -1;

    // Time complexity: O(1)
    public static void push(int element) {
        pointer++;
        stack.add(pointer, element);
    }

    // Time complexity: O(1)
    public static int pop() {
        int ele = -1;
        if(pointer >= 0) {
            ele = stack.get(pointer);
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
            System.out.print(stack.get(i)+" ");
        }
    }
}
