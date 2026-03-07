/*
416. Partition Equal Subset Sum
Medium
Topics
premium lock icon
Companies
Given an integer array nums, return true 
if you can partition the array into two subsets such 
that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
  */

import java.util.Arrays;

class Solution {
    // using recursion
    // boolean solve(int idx, int[] nums, int target){
    // if(target == 0) return true;
    // if(idx == 0){
    // if(nums[idx] != target) return false;
    // else return true;
    // }
    // boolean nottaken = solve(idx-1, nums, target);
    // boolean taken = false;
    // if(nums[idx] <= target){
    // taken = solve(idx-1, nums, target - nums[idx]);
    // }
    // return taken || nottaken;
    // }
    // public boolean canPartition(int[] nums) {
    // int totalsum = 0;
    // for(int num : nums){
    // totalsum += num;
    // }
    // if(totalsum % 2 == 1) return false;
    // int target = totalsum / 2;
    // return solve(nums.length - 1, nums, target);
    // }
    // using memoization
    Boolean[][] dp;

    boolean solveMemo(int idx, int[] nums, int target) {
        if (target == 0)
            return true;
        if (idx == 0) {
            if (nums[idx] != target)
                return false;
            else
                return true;
        }
        if (dp[idx][target] != null)
            return dp[idx][target];
        boolean nottaken = solveMemo(idx - 1, nums, target);
        boolean taken = false;
        if (nums[idx] <= target) {
            taken = solveMemo(idx - 1, nums, target - nums[idx]);
        }
        return dp[idx][target] = taken || nottaken;
    }

    public boolean canPartition(int[] nums) {
        int totalsum = 0;
        for (int num : nums) {
            totalsum += num;
        }
        if (totalsum % 2 == 1)
            return false;
        int target = totalsum / 2;
        dp = new Boolean[nums.length][target + 1];
        for (Boolean[] row : dp) {
            Arrays.fill(row, null);
        }
        return solveMemo(nums.length - 1, nums, target);
    }
}

public class PartionEqualsSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 5, 11, 5 };
        System.out.println(sol.canPartition(nums));
    }
}
