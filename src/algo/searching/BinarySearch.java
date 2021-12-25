package algo.searching;

/*
    Binary Search

    Given an array of integers nums which is sorted in ascending order, and an integer target,
    write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

    You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;

        while(start <= end) {
            int midIndex = (start+end)/2;

            if(nums[midIndex] == target) {
                return midIndex;
            } else if(nums[midIndex] < target) {
                start = midIndex + 1;
            } else if(nums[midIndex] > target) {
                end = midIndex - 1;
            }
        }
        return -1;
    }
}
