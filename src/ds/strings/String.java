package ds.strings;

import java.util.Arrays;

/*
    CharSequence interface - top level interface
    String, AbstractStringBuilder, StringBuilder, StringBuffer implements CharSequence
    StringBuilder, StringBuffer extends AbstractStringBuilder

    String is immutable
    StringBuilder is mutable
    StringBuffer is mutable and synchronized (thread safe)

    String is built on top of char array
    Any method that deals with array, internally uses
    System.arraycopy(value, 0, result, 0, value.length); O(n), but faster because of native implementation (by JVM or C or C++)

    Java has designed a special mechanism for keeping the String literals - in a so-called string common pool.
    If two String literals have the same contents, they will share the same storage locations inside the common pool.

    String object created via the new operator are kept in the heap.
    Each String object in the heap has its own storage just like any other object.
 */
public class String {

    private char[] value;

    /*public String(java.lang.String str) {
        this.value = str.value // how to access value, check String constructor
    }*/

    public String(char[] chars) {
        this.value = Arrays.copyOf(chars, chars.length);
    }

    public int length() {
        return value.length;
    }

    public char[] toCharArray() {
        // return Arrays.copyOf(str.value, str.length());
        // Cannot use Arrays.copyOf because of class initialization order issues
        // looks like toCharArray of String class is called during class initialization(VM initialization)
        // , before arrays

        char[] chars = new char[value.length];
        System.arraycopy(value, 0, chars, 0, value.length);
        return chars;
    }

    public char charAt(int index) {
        if((index < 0) || (index >= value.length)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }

    /*public boolean contains() {

        for(int i=0; i<value.length; i++) {
            if()
        }
    }*/



    public static void main(java.lang.String[] args) {

        java.lang.String a = "hello";
        java.lang.String b = "hello";

        System.out.println(a == b); // pointing to same reference stored in string pool

        java.lang.String c = new java.lang.String("hello"); // stored in heap
        java.lang.String d = new java.lang.String("hello"); // stored in heap

        System.out.println(c == d);
        System.out.println(c.equals(d));

        // Custom String class
        char[] input = {'J', 'a', 'm', 'e', 's', 'B', 'o', 'n', 'd'};

        String newString = new String(input);

        //c.contains()
       /* c.toLowerCase(Locale.ROOT);
        c.toUpperCase();
        c.compareTo();
        c.compareToIgnoreCase();
        c.concat();
        c.contains();
        c.contentEquals();
        c.equals();
        c.endsWith();
        c.startsWith();
        c.substring();
        c.trim();
        c.endsWith();
        c.indexOf();
        c.isEmpty();
        c.lastIndexOf();
        c.codePointAt();
        c.codePointBefore();
        c.replace();
        c.intern();
        c.matches();
        c.split();
        c.subSequence();*/
    }
}
