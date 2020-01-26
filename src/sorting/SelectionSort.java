package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};

        int startIndex = 0;
        int arrayLength = arr.length;
        boolean isMinElementChanged = false;

        int iterationRequiredForSorting = arrayLength - 1; /* need minimum two elements to compare */

        while(startIndex < iterationRequiredForSorting) {

            int minElement = arr[startIndex];
            int minElementIndex = startIndex;

            for(int i = startIndex + 1; i < arrayLength; i++) {
                if(minElement > arr[i]) {
                    minElement = arr[i];
                    minElementIndex = i;
                    isMinElementChanged = true;
                }
            }

            if(isMinElementChanged) { /* Swap only if MinElement is identified */
                arr[minElementIndex] = arr[startIndex];
                arr[startIndex] = minElement;
                isMinElementChanged = false;
            }
            startIndex++;
        }

        for(int elementInArr : arr) {
            System.out.println(elementInArr);
        }
    }
}
