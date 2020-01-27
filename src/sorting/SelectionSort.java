package sorting;

/*
    1. initialize the lowest element and it's index with first element's value and index.
    2. find lowest element in array, save the element and index.
    3. swap the lowest element with first element.
    4. one element is sorted, increment the start index and continue with unsorted array.

    Time complexity : o(n * n)
    Stablity: Needs to be verified
 */

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {35, 23, 75, 34, 34};

        int startIndex = 0;
        int arrayLength = arr.length;
        boolean isMinElementChanged = false;

        int iterationRequiredForSorting = arrayLength - 1; /* need minimum two elements to compare */

        while(startIndex < iterationRequiredForSorting) {

            int minElement = arr[startIndex]; /* STEP 1 */
            int minElementIndex = startIndex;

            for(int i = startIndex + 1; i < arrayLength; i++) { /* STEP 2 */
                if(minElement > arr[i]) {
                    minElement = arr[i];
                    minElementIndex = i;
                    isMinElementChanged = true;
                }
            }

            if(isMinElementChanged) { /* Swap only if MinElement is identified */
                arr[minElementIndex] = arr[startIndex]; /* STEP 3 */
                arr[startIndex] = minElement;
                isMinElementChanged = false;
            }
            startIndex++; /* STEP 4 */
        }

        Utility.printArray(arr);
    }
}
