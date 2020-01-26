package sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {5, 1, 4, 2, 8};

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

        for(int element: arr) {
            System.out.println(element);
        }
    }
}
