/*
69. Sqrt(x)
Easy

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned. */


class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int lo = 1, hi = x / 2;
        int ans = 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid <= x / mid) { // mid*mid <= x without overflow
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }
  // using linear search
   public int MySqrt(int x) {
        if (x < 2) return x;

        for(int i= 0; i*i <= x; i++) {
            if ( (i+1)*(i+1) > x) {
                return i;
            }

        }
        return -1;
    }

}

public class SquareRoot {
    public static void main(String[] args) {
        
    }
}