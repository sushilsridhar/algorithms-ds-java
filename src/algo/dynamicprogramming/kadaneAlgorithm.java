package algo.dynamicprogramming;

/*
    Technique: kadane's algorithm

    Find the contiguous subarray within an array, A of length N which has the largest sum.

    5, 6, 7, -3, 2, -10, -12, 8, 12, 21 --> ans = 41

    The subarray [8 12 21] has the maximum possible sum of 41

    A = [-2,1,-3,4,-1, 2, 1, -5, 4] --> ans = 6, subarray [4, -1, 2, 1]
    A=  [-2, -3, -4, -1, -2, -1, -5, -4] --> ans = -1, subarray [-1]

    approach:

      _ 7 13  2 4 _
     -5

     7 13 2 4 is a subarray with sum 26,
     suppose first blank, that is element before 7 is -5, we should not consider the subarray [-5 7 13  2 4], sum 21, which decreases the total sum

     _  _ 7 13  2 4 _
    12 -5

    now 12 + (-5) -> 7, 7 is positive so this number will contribute to the total sum, subarray [12 -5 7 13  2 4], sum = 33, increases the total sum

    if previous subarray sum is positive, consider it as subarray,
    if previous subarray sum is negative, ignore the subarray, and consider the subarray starting from current index
 */
public class kadaneAlgorithm {

    public static void main(String[] args) {

        int[] nums = { 5, 6, 7, -3, 2, -10, -12, 8, 12, 21 }; // output -> 41

        System.out.println(kadaneAlgo(nums));
    }

    public static int kadaneAlgo(int[] a) {

        int currentSum = 0, max = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++) {

            currentSum = currentSum + a[i];
            max = Math.max(max, currentSum);

            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        return max;
    }

}
