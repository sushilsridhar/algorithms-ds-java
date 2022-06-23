package ds.stack;

public class TestStackUsingSinglyLinkedList {

    public static void main(String[] args) {

        StackUsingSinglyLinkedList<Integer> stack = new StackUsingSinglyLinkedList<>();
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
