/*
Longest subarray with sum K
Subscribe to TUF+

Hints
Company
Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.


Example 1

Input: nums = [10, 5, 2, 7, 1, 9],  k=15

Output: 4

Explanation:

The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.

Example 2

Input: nums = [-3, 2, 1], k=6

Output: 0

Explanation:

There is no sub-array in the array that sums to 6. Therefore, the output is 0.
 */

import java.util.HashMap;
import java.util.Map;


class Solution {
    public int longestSubarray(int[] nums, int k) {
         int maxlen = 0;
         Map<Integer , Integer> map = new HashMap<>();
         int sum = 0;
         int n = nums.length;

         for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if(sum == k) {
                maxlen = Math.max(maxlen, i + 1);
            }
            
         }
         return maxlen;
    }
}
public class LongestSubArrWithSumK {
    
}
