package algo.arrays;

/*
    Two pointer approach:

    {0, 1, 1, 1, 2, 2, 3, 3, 4}
    first element is always unique, leave it as it is.
    start the iteration from 1,
    compare 1, 0 -> compare current element and previous element, nums[i] != nums[i-1]

    if they are not equal, then element i is unique, add to front half of the array
     0  1  2  3  4  5  6  7  8 - index
    {0, 1, 1, 1, 2, 2, 3, 3, 4}
     index 1,0 -> add a[1]
     index 2,1 -> do nothing
     index 3,2 -> do nothing
     index 4,3 -> add a[4]
     index 5,4 -> do nothing
     index 6,5 -> add a[6]
     index 7,6 -> do nothing
     index 8,7 -> add[8]

    [0, 1, 2, 3, 4, 2, 3, 3, 4]
 */
public class RemoveDuplicatesInArray {

    public static void main(String[] args) {

        int[] n = {0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(n));

    }

    public static int removeDuplicates(int[] nums) {

        int n = nums.length;

        if(n==0) {
            return 0;
        }

        if(n==1) {
            return 1;
        }

        int insertIndex = 1;
        for(int i=1; i<n; i++) {
            if(nums[i] != nums[i-1]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }
}
