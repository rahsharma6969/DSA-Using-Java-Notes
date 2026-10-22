/*
152. Maximum Product Subarray
Medium
Topics
premium lock icon
Companies
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray. */

import java.util.Arrays;


class Solution {
  
    // public int maxProduct(int[] nums) {
    //     int n = nums.length;
      
    //    int currentMax = nums[0];
    //    int currentMin = nums[0];

    //    for(int i = 1; i < n; i++) {
    //        int temp = currentMax;
    //        currentMax = Math.max(nums[i], Math.max(currentMax * nums[i], currentMin * nums[i]));
    //        currentMin = Math.min(nums[i], Math.min(temp * nums[i], currentMin * nums[i]));
    //    }

    //    return currentMax;

    // }

    public int maxProduct(int[] nums) {
        int maxEnding = nums[0];
        int minEnding = nums[0];

        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            int tempMax = Math.max(
                num,
                Math.max(num * maxEnding, num * minEnding)
            );

            int tempMin = Math.min(
                num,
                Math.min(num * maxEnding, num * minEnding)
            );

            maxEnding = tempMax;
            minEnding = tempMin;

            ans = Math.max(ans, maxEnding);
        }

        return ans;
    }
}
public class MaximumProductSubarray {
    
}
