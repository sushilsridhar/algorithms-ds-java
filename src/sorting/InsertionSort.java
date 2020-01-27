package sorting;

public class InsertionSort {
    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6};

        int length = arr.length;
        int marker = 1;
        int unsortedArrayLength = 1;

        while(marker < length) {

            for(int i = unsortedArrayLength -1; i >= 0; i--) {
                System.out.println("------marker="+marker+" i="+i);
                if(arr[marker] < arr[i]) {
                    int temp = arr[marker];
                    arr[marker] = arr[i];
                    arr[i] = temp;
                }
                Utility.printArray(arr);
            }
            marker++;
            unsortedArrayLength++;
        }

    }
}
