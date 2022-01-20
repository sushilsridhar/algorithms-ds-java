package algo.searching.binarysearchtemplate.one;

/*
    Given a non-negative integer x, compute and return the square root of x.

    Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

    Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

    Input: x = 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 */
public class Sqrt {

    public static void main(String[] args) {
        int num = 8;
        System.out.println(mySqrt(num));
    }

    public static int mySqrt(int x) {

        if(x == 0) {
            return 0;
        }
        if(x < 4) {
            return 1;
        }

        int left = 2, right = x/2;
        int ans = 0;

        while(left<=right) {
            int center = left + (right-left)/2;

            long square = (long)center*center;

            if(square == x) {
                return center;
            } else if (square < x) {
                left = center + 1;
                ans = center;
            } else if(square > x) {
                right = center - 1;
            }
        }
        return ans;
    }
}
