package algo.arrays;

/*
      array length divided by 2 gives number of swaps required
      swap start index with last index, continue until number of swaps.

      Time complexity: o(n), where n is array length divided by 2.
*/
public class ReverseArray {

    public static void main(String [] args) {

        int arr[] = {1, 2, 3, 4, 5, 6};

        // IDEA 1
        int number_of_swaps_required = (arr.length)/2;

        for(int start_index = 0; start_index< number_of_swaps_required; start_index++) {
            int last_index = arr.length -start_index -1;

            /*int temp = arr[start_index];
            arr[start_index] = arr[last_index];
            arr[last_index] = temp;*/

            // swap without extra variable

            arr[start_index] = arr[start_index] ^ arr[last_index]; // a = a ^ b
            arr[last_index] = arr[start_index] ^ arr[last_index];  // b = a ^ b
            arr[start_index] = arr[start_index] ^ arr[last_index]; // a = a ^ b
        }

        for(int i : arr) {
            System.out.println(i);
        }

        // IDEA 2
        int arr2[] = {1, 2, 3, 4, 5, 6};
        int i=0,j=arr.length-1;

        while(i<j) {
            int temp = arr2[i];
            arr2[i] = arr2[j];
            arr2[j] = temp;

            i++;
            j--;
        }

        for(int k : arr2) {
            System.out.println(k);
        }
    }
}
