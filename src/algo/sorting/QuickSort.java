package algo.sorting;

/*
    Quick Sort
    1. select a pivot
    2. partition the array according to the pivot
    3. all elements on the left side of the pivot should be less than pivot, right side of pivot should be greater than pivot
    4. return the pivot index after sorting and partition
    5. call quick sort recursively on both segments

    NOTE: quick sort execution time is less or almost near to nlogn tc, if a random pivot is selected
    there is no proof for this

    pivot can be start, end, random or median of the array

    0  1  2  3  4  5   6  7
    2, 3, 1, 7, 6, 4, 11, 5  --> pivot = 5

    i=-1, j=0, p = 5 --> 1 < 5 , swap(a, 0, 0)
    i=0,  j=1, p = 5 --> 3 < 5 , swap(a, 1, 1)
    i=1,  j=2, p = 5 --> 1 < 5 , swap(a, 2, 2)
    i=2,  j=3, p = 5 --> 7 < 5
    i=2,  j=4, p = 5 --> 6 < 5
    i=2,  j=5, p = 5 --> 4 < 5 , swap(a, 3, 5)
    i=3,  j=6, p = 5 --> 11 < 5

    0  1  2  3  4  5   6  7
    2, 3, 1, 4, 6, 7, 11, 5  --> pivot = 5

    swap pivot and i+1, so that all elements on left < pivot and right > pivot

    After first processing with pivot 5,

    0  1  2  3  4  5   6  7
    2, 3, 1, 4, 5, 7, 11, 6  --> pivot index = 4

    now process,
    start to 3 (pivot - 1)
    (pivot + 1) 5 to end

    best tc: O(nlogn), 2T(n/2) + n
    worst tc: O(n^2), T(n-1) + n

 */
public class QuickSort {

    public static void main(String[] args) {
                //  0  1  2  3  4  5   6  7
        int[] a = { 2, 3, 1, 7, 6, 4, 11, 5};

        quickSort(a, 0, a.length-1);

        for(int i: a) {
            System.out.print(i+" ");
        }
    }

    private static void quickSort(int[] a, int start, int end) {

        if(end <= start) { // valid subarray is start >=end
            return;
        }

        int pivot = partition(a, start, end);
        quickSort(a, start, pivot-1);
        quickSort(a, pivot+1, end);

    }

    private static int partition(int[] a, int start, int end) {

        int pivot = a[end];
        int i = start - 1;

        for(int j=start; j<end; j++) {
            if(a[j] < pivot) {
                i++;
                swap(a, i, j);
            }
        }

        swap(a, i+1, end);
        return i+1; // return pivot index
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
