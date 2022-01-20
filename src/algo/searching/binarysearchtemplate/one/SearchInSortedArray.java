package algo.searching.binarysearchtemplate.one;

/*
    There is an integer array nums sorted in ascending order (with distinct values).

    Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

    Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

    You must write an algorithm with O(log n) runtime complexity.

    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4


    Constraints:

    1 <= nums.length <= 5000
    -104 <= nums[i] <= 104
    All values of nums are unique.
    nums is an ascending array that is possibly rotated.
    -104 <= target <= 104
 */
public class SearchInSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int minElement = Integer.MAX_VALUE;
        int minElementIndex = 0;

        for(int i=0; i<n; i++) {
            if(nums[i] < minElement) {
                minElement = nums[i];
                minElementIndex = i;
            }
        }

        if(minElementIndex == 0) {
            return binarySearch(nums, 0, n-1, target);
        }

        int ans = -1;
        if(target >= nums[0]) {
            ans = binarySearch(nums, 0, minElementIndex-1, target);
        } else {
            ans = binarySearch(nums, minElementIndex, n-1, target);
        }

        return ans;
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {

        while(left<=right) {

            int center = left + (right-left)/2;

            if(target == center) {
                return center;
            } else if(target > center) {
                left = center + 1;
            } else if(target < center) {
                right = center - 1;
            }
        }


        return -1;
    }
}
