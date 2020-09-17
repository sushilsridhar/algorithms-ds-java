package random;

public class BoyerMooreVoting {
    public static void main(String[] args) {

        int a[] = {7, 7, 5, 7, 5, 1  , 5, 7  , 5, 5, 7, 7  ,7, 7, 7, 7 };

        //int a[] = {3,1,3,3,2};

        /* not working for below input */
        //int a[] = {17, 19, 9, 5, 3, 6, 17, 7, 18, 16, 18, 11, 3, 15, 2 };

        int result = majorityElement(a);

        System.out.println(result);
    }

    private static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        if(count <= 1) {
            return -1;
        }

        return candidate;
    }
}
