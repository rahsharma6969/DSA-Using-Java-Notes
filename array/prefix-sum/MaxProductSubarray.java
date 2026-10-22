/*
152. Maximum Product Subarray
Solved
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
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

 */

class Solution {
    public int maxProduct(int[] nums) {

        int ans = nums[0];

        // Left → Right
        int product = 1;

        for (int i = 0; i < nums.length; i++) {

            product *= nums[i];

            ans = Math.max(ans, product);

            if (product == 0) {
                product = 1;
            }
        }

        // Right → Left
        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            product *= nums[i];

            ans = Math.max(ans, product);

            if (product == 0) {
                product = 1;
            }
        }

        return ans;
    }
}

public class MaxProductSubarray {
    
}
