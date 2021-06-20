package ds.arrays;

import java.util.ArrayList;

/*
*   ArrayList in Java
*
*   get(index)              - O(1)
*   push(element)           - O(1)
*   add(index, element)     - O(n)
*   pop                     - O(n)
*   remove(index)           - O(n)
*/
public class DynamicArray {

    private int capacity = 10; //default size is 10 in ArrayList - Java 8
    private int length = 0;
    private int[] internalArray = new int[capacity];


    public int get(int index) {
        return internalArray[index];
    }

    public void push(int element) {
        internalArray[length] = element;
        length++;
    }

    public void add(int index, int element) {
        int[] newArray = new int[capacity];

        for(int i=0,j=0; i<length; i++,j++) {
            if(i == index) {
                newArray[i] = element;
                i++;
            }
            newArray[i] = internalArray[j];
        }

        internalArray = newArray;
        length++;
    }

    public void pop() {
        int[] newArray = new int[capacity];

        int lastElementIndex = length-1;
        for(int i=0; i<lastElementIndex; i++) {
            newArray[i] = internalArray[i];
        }
        internalArray = newArray;
        length--;
    }

    public void remove(int index) {

        if(index == length-1) {
            pop();
            return;
        }

        int[] newArray = new int[capacity];

        for(int i=0,j=0; i<length && j<length; i++,j++) {
            if(i == index) {
                j++;
            }
            newArray[i] = internalArray[j];
        }
        internalArray = newArray;
        length--;
    }

    public String toString(DynamicArray dynamicArray) {

        StringBuilder builder = new StringBuilder(); // TODO learn

        builder.append("[");
        for(int i=0; i< dynamicArray.capacity; i++) {
            builder.append(dynamicArray.get(i));
            builder.append(", ");
        }
        builder.append("]");

        return builder.toString();
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();

        DynamicArray dynamicArray = new DynamicArray();

        System.out.println(dynamicArray.get(0));

        dynamicArray.push(4);
        dynamicArray.push(45);
        dynamicArray.push(90);
        dynamicArray.push(80);
        dynamicArray.pop();
        dynamicArray.push(70);
        dynamicArray.push(100);

        dynamicArray.remove(0);

        dynamicArray.add(3, 99);

        System.out.println(dynamicArray.toString(dynamicArray));
        System.out.println(dynamicArray.length);

    }

}
