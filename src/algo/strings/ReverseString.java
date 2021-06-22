package algo.strings;

/*


 */
public class ReverseString {

    public static void main(String[] args) {

        String input = "hello world";

        String reverse = reverseUsingCharArray(input); // O(n)
        System.out.println(reverse);

        String reverseTwo = reverseUsingCharAt(input); // O(n)
        System.out.println(reverseTwo);

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
