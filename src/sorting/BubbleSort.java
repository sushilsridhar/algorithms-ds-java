package sorting;

/*
    1. initialize the pointer's value and index to first element's value and index.
    2. compare the pointer element and next element.
    3. if p > n, swap the two elements, if not don't swap.
    4. move the pointer to next element.

    Time Complexity: O( n * n )
    Stability: Yet to be verified
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int arr[] = {5, 1, 4, 2, 8};

        int arr[] = {45, 1, 3, 52, 81, 23};

        int iterations = 0;
        int length = arr.length;

        while(iterations < length) {

            boolean isCompletelySorted = true;
            int currentIndex = 0;

            for(int i = currentIndex+1; i < length; i++) {

                if(arr[currentIndex] > arr[i]) {
                    int temp;

                    temp = arr[i];
                    arr[i] = arr[currentIndex];
                    arr[currentIndex] = temp;
                    isCompletelySorted = false;
                }
                currentIndex++;
            }
            if(isCompletelySorted) {
                break;
            }
            iterations++;
        }

        Utility.printArray(arr);
    }
}
