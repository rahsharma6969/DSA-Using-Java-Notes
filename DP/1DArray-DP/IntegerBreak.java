/*
343. Integer Break
Medium
Topics
premium lock icon
Companies
Hint
Given an integer n, break it into the sum of k positive integers,
where k >= 2, and maximize the product of those integers.

Return the maximum product you can get.

 

Example 1:

Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36. */ 


class Solution {
    int solve(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
    
        while (n > 4) {
            n -= 3;
        }

        return solve(n - 1) * 1;

    }
    public int integerBreak(int n) {
        
        if ( n == 2) return 1;
        if( n == 3) return 2;

       solve(n);
       
    }
}
public class IntegerBreak {
    
}
