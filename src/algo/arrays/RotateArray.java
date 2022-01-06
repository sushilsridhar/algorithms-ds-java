package algo.arrays;

/*

    Right rotation - move elements from right to left
    7 8 9 10 1 2 3 4 5 6

    int k = numberOfRotation%n; // this is must, n = { 1, 2, 3}; 4shifts to this array is same as 1 shift

    1 - reverse the whole array - 10 9 8 7 6 5 4 3 2 1
    2 - reverse the array from 0 to  number of shifts - 1, 7 8 9 10 6 5 4 3 2 1
    3 - reverse the array from number of shifts to array length -1 , 7 8 9 10 1 2 3 4 5 6


    Left rotation - move elements from left to right
    A = [1, 2, 3, 4, 5] , k = 2

    3 4 5 1 2

 */
public class RotateArray {
    public static void main(String[] args) {

        int[] brute = { 1, 2, 3, 4, 5};
        int bruteK = 4;

        bruteForceRightRotation(brute, bruteK);
        //printArray(brute);

        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        efficentRightRotation(a, 5);
        printArray(a);

        int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        efficentLeftRotation(b, 4);
        printArray(b);
    }

    // Time complexity: n/2 + k/2 + n/2-k/2 - > 2n/2 -> O(n)
    private static void efficentRightRotation(int[] a, int numberOfRotation) {
        int n = a.length;
        int k = numberOfRotation%n; // this is must, n = { 1, 2, 3}; 4shifts to this array is same as 1 shift

        reverse(a, 0, n-1); // O(n/2)
        reverse(a,0, k-1);  // O(k/2)
        reverse(a, k, n-1);    // -> (n-1-k-1)/2 -> O((n-k)/2)

    }

    // Time complexity: n/2 + (n-1-k)/2 + (k-1)/2 - > 2n/2 -> O(n)
    private static void efficentLeftRotation(int[] b, int numberOfRotation) {
        int n = b.length;
        int k = numberOfRotation%n; // this is must, n = { 1, 2, 3}; 4shifts to this array is same as 1 shift

        reverse(b, 0, n-1); // O(n/2)
        reverse(b,0, n-1-k);  // (n-1-k)/2
        reverse(b, n-k, n-1);  // n-1-n+k -> (k-1)/2

    }

    private static void reverse(int[] a, int s, int e) {

        while(s<e) {
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }

    private static void bruteForceRightRotation(int[] brute, int bruteK) {

        bruteK = bruteK % brute.length; // this is must, eg, n = { 1, 2, 3}; 4 shifts to this array is same as 1 shift

        for(int i=0; i<bruteK; i++) {
            int prev = brute[brute.length-1];
            for(int j=0; j<brute.length; j++) {
                int temp = brute[j];
                brute[j] = prev;
                prev = temp;
            }
        }
    }

    private static void printArray(int[] a) {

        System.out.println("");

        for(int element: a) {
            System.out.print(element+" ");
        }
    }
}
