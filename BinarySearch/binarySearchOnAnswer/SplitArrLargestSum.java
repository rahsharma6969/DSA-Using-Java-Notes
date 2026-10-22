
/*
410. Split Array Largest Sum
Hard
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)
 */



class Solution {
    // Brute force: try every possible placement of the k - 1 cuts.
    public int splitArray(int[] nums, int k) {
        return findMinimumLargestSum(nums, 0, k, 0);
    }

    private int findMinimumLargestSum(int[] nums, int start, int partsRemaining, int largestSum) {
        if (partsRemaining == 1) {
            int lastPartSum = 0;
            for (int i = start; i < nums.length; i++) {
                lastPartSum += nums[i];
            }
            return Math.max(largestSum, lastPartSum);
        }

        int minimumLargestSum = Integer.MAX_VALUE;
        int currentPartSum = 0;

        // Leave at least one element for each remaining part.
        for (int end = start; end <= nums.length - partsRemaining; end++) {
            currentPartSum += nums[end];
            int result = findMinimumLargestSum(
                    nums,
                    end + 1,
                    partsRemaining - 1,
                    Math.max(largestSum, currentPartSum));
            minimumLargestSum = Math.min(minimumLargestSum, result);
        }

        return minimumLargestSum;
    }
}
public class SplitArrLargestSum {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        System.out.println(new Solution().splitArray(nums, k)); // 18
    }
}
