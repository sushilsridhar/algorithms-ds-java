package ds.stack;

import ds.interfaces.Deque;
import ds.list.LinkedList;

/*
    Test Stack implementation methods in LinkedList class
 */
public class Test {

    public static void main(String[] args) {

        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);
        stack.pop();
        stack.push(5);
        stack.push(6);
        stack.pop();
        stack.push(7);

        System.out.println(stack.size());

        while(stack.size() != 0) {
            System.out.print(stack.pop()+" ");
        }
    }
}
