/*
231. Power of Two
Easy
Topics
premium lock icon
Companies
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

 

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false
  */


class Solution {

    // time complexity is O(log n) and space complexity is O(1)
    public boolean isPowerOfTwo(int n) {
        if( n <=0) return false;
        while(n > 1) {
            if(n % 2 != 0) return false;
        }
        return true;
        
    }

    // using bit manipulation
    public boolean isPowerOfTwoBitManipulation(int n) {
        if(n <= 0) return false;
        return (n & (n-1)) == 0;
    }
}

public class powerOfTwo {
    
}
