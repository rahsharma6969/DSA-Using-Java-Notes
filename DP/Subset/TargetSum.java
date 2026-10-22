/*
Target sum
Subscribe to TUF+

Hints
Company
Given an array nums of n integers and an integer target,
 build an expression using the integers from nums where 
 each integer can be prefixed with either a '+' or '-' sign.



The goal is to achieve the target sum by evaluating all possible combinations of these signs.



Determine the number of ways to achieve the target sum and return your answer with modulo 109+7.


Example 1

Input: nums = [1, 2, 7, 1, 5], target = 4

Output: 2

Explanation: There are 2 ways to assign symbols to make the sum of nums be target 4.

+1 + 2 + 7 - 1 - 5 = 4

-1 + 2 + 7 + 1 - 5 = 4

Example 2

Input: nums = [1], target = 1

Output: 1

Explanation: There is only one way to assign symbols to make the sum of nums be target 1.

Now your turn!

Input: nums = [2, 1, 3, 1, 2], target = 2 */

import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;

    int solver(int[] nums , int idx, int target, int[][] dp) {
        if(idx == 0) {
            if (nums[0] == 0) return target == 0 ? 2 : 0;
            return target == 0 || nums[0] == target ? 1 : 0;
        }
        
        if(dp[idx][target] != -1) {
            return dp[idx][target];
        }
        int nottaken = solver(nums, idx-1, target, dp);
        int taken = 0;
        if(nums[idx] <= target) {
            taken = solver(nums, idx-1, target - nums[idx], dp);
        }
        return dp[idx][target] = (taken + nottaken) % MOD;
    }
    public int targetSum(int n, int target, int[] nums) {

      if (n == 0) return target == 0 ? 1 : 0;

      long totalSum = 0;
      for(int i = 0; i < n; i++) {
          totalSum += nums[i];
      }

      if (target < -totalSum || target > totalSum) return 0;
      long subsetSumWithSign = totalSum + target;
      if (subsetSumWithSign % 2 != 0) return 0;

      int subsetTarget = (int) (subsetSumWithSign / 2);
      int[][] dp = new int[n][subsetTarget + 1];
      for(int[] row : dp) {
          Arrays.fill(row, -1);
      }
      return solver(nums, n-1, subsetTarget, dp);
    }
}


public class TargetSum {
    
}
