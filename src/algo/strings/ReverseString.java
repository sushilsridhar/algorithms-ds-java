package algo.strings;

/*
    CharSequence interface - top level interface
    String, AbstractStringBuilder, StringBuilder, StringBuffer implements CharSequence
    StringBuilder, StringBuffer extends AbstractStringBuilder

    String is immutable
    StringBuilder is mutable
    StringBuffer is mutable and synchronized (thread safe)

    String in built on top of char array
    Any method that deals with array, internally uses
    System.arraycopy(value, 0, result, 0, value.length); O(n), but faster because of native implementation (by JVM or C or C++)
 */
public class ReverseString {

    public static void main(String[] args) {

        String input = "hello world";

        String reverse = reverseUsingCharArray(input); // O(n)
        System.out.println(reverse);

        String reverseTwo = reverseUsingCharAt(input); // O(n)
        System.out.println(reverseTwo);

        String reverseThree = reverseUsingArrayReverse(input); // O(n)
        System.out.println(reverseThree);
    }

    private static String reverseUsingArrayReverse(String input) {

        char[] chars = input.toCharArray(); // o(n)

        int number_of_swaps_required = (chars.length)/2;

        int last_index;
        char temp;

        for(int start_index = 0; start_index < number_of_swaps_required; start_index++) { // run n/2 times --> o(n)

            last_index = chars.length -start_index -1;

            temp = chars[start_index];
            chars[start_index] = chars[last_index];
            chars[last_index] = temp;
        }

        return String.copyValueOf(chars); // o(n)
    }

    private static String reverseUsingCharAt(String input) {

        StringBuilder output = new StringBuilder();

        for(int i=input.length()-1; i>=0; i--) { //O(n)
            output.append(input.charAt(i));
        }

        return output.toString();
    }

    private static String reverseUsingCharArray(String input) {

        char[] inputArray = input.toCharArray(); // o(n)

        char[] output = new char[inputArray.length];

        for(int i=inputArray.length-1, j=0; i>=0; i--,j++) {  // o(n)
            output[j] = inputArray[i];
        }

        return String.copyValueOf(output); // o(n)
    }
}
