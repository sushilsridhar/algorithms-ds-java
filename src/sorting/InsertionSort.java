package sorting;

public class InsertionSort {
    public static void main(String[] args) {

        //int arr[] = { 67,55 ,24,34,53, 45,31,34};
        int arr[] = {12, 11, 13, 5, 6};

        int length = arr.length;
        int marker = 1;
        int sortedArrayLength = 1;

        while(marker < length) {
            int indexToBeCompared = marker;

            for(int i = sortedArrayLength -1; i >= 0; i--) {
                if(arr[indexToBeCompared] < arr[i]) {
                    int temp = arr[indexToBeCompared];
                    arr[indexToBeCompared] = arr[i];
                    arr[i] = temp;
                    indexToBeCompared = i;
                }
            }
            marker++;
            sortedArrayLength++;
        }
        Utility.printArray(arr);
    }
}
