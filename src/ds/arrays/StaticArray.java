package ds.arrays;

/*

Arrays are contiguous sections within memory,
so to create an array you would need to reserve a chunk of memory which is of size n * sizeof(type),
where n is the amount of items you would like to store and the sizeof(type) would return the size,
in bytes which the JVM would need to represent that given type.

You would then store a reference (pointer) to the first location of your memory segment,
say 0x00, and then you use that as a base to know how much you need to move to access the elements,
so a[n] would be equal to doing 0x00 + (n * sizeof(type)).


Static arrays are built in languages features in C++ and Java,
can not be implemented without using another data structure.

 */
public class StaticArray {

    public int length;
    Word[] word;

    static class Word { // Word is collection of 32bits or 64bits, based on the computer
        int value;
    }

    public StaticArray(int size) {
        this.length = size;
        word = new Word[size];

        for(int i=0; i<size; i++) {
            word[i] = new Word();
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[10];
        System.out.println(arr.getClass().getName());
        // - output [I , [ - means 1 dimensional, I - integer , class created at run time

        System.out.println(arr.length); // length is 10, same as the capacity of array
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]); // prints 10 zeros
        }

        StaticArray array = new StaticArray(5);

        for(int i=0; i<5; i++) {
            array.word[i].value = i;
        }

        for(int i=0; i<array.length; i++) {
            System.out.println("Array value is: "+array.word[i].value);
        }
    }
}
