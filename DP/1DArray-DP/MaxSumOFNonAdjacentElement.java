/*
Given an array arr containing positive integers. 
Find the maximum sum of elements of any possible subsequence such that 
no two numbers in the subsequence should be adjacent in array arr[].

Examples:

Input: arr[] = [5, 5, 10, 100, 10, 5]
Output: 110
Explanation: If you take indices 0, 3 and 5, then = 5+100+5 = 110.
Input: arr[] = [3, 2, 7, 10]
Output: 13
Explanation: 3 and 10 forms a non continuous subsequence with maximum sum. */


// NOte : Here we are not forced to either start from the first element or the second element like the 
// min cost climbing stairs problem, we can start from any element
// we can start from any element,
//  so we will check for both the cases and return the maximum of the two cases.
class Solution {

    int maxCost(int[] nums, int idx) {
        if (idx == 0) return nums[0];
        if (idx == 1) return Math.max(nums[0], nums[1]);

        return Math.max(nums[idx] + maxCost(nums, idx - 2), // take
        maxCost(nums, idx-1));
    }
    int findMaxSum(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        return maxCost(nums, n - 1);

    }

    // using memoization
    int maxCostMemo(int[] nums, int idx, int[] dp) {
        if (idx == 0) return nums[0];
        if (idx == 1) return Math.max(nums[0], nums[1]);

        if (dp[idx] != -1) return dp[idx];

        dp[idx] = Math.max(nums[idx] + maxCostMemo(nums, idx - 2, dp), // take
                maxCostMemo(nums, idx-1, dp));
        return dp[idx];
    }
    int findMaxSumMemo(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return maxCostMemo(nums, n - 1, dp);

    }
}

public class MaxSumOFNonAdjacentElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 7, 10};
       
        Solution sol = new Solution();
        System.out.println(sol.findMaxSum(nums));
    }
}
