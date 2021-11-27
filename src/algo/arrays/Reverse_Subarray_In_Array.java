package algo.arrays;

public class Reverse_Subarray_In_Array {

    public static void main(String [] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int start_index = 3;
        int end_index = 7;

        for(int i = start_index,j=end_index; i<j ; i++, j--) {

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            // swap without extra variable

            /*arr[start_index] = arr[start_index] ^ arr[last_index]; // a = a ^ b
            arr[last_index] = arr[start_index] ^ arr[last_index];  // b = a ^ b
            arr[start_index] = arr[start_index] ^ arr[last_index]; // a = a ^ b*/
        }

        for(int i : arr) {
            System.out.print(i+" ");
        }
    }
}
