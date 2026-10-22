
/*
Count subsets with sum K
Subscribe to TUF+

Hints
Company
Given an array arr of n integers and an integer K, count the number of subsets of the given array that have a sum equal to K. Return the result modulo (109 + 7).


Example 1

Input: arr = [2, 3, 5, 16, 8, 10], K = 10

Output: 3

Explanation: The subsets are [2, 8], [10], and [2, 3, 5].

Example 2

Input: arr = [1, 2, 3, 4, 5], K = 5

Output: 3

Explanation: The subsets are [5], [2, 3], and [1, 4]. */

class Solution {
    int solver(int idx, int[] arr, int target, Integer[][] dp) {
        if (idx == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || arr[0] == target) return 1;
            return 0;
        }

        if (dp[idx][target] != null) {
            return dp[idx][target];
        }

        int notTaken = solver(idx - 1, arr, target, dp);
        int taken = 0;
        if (arr[idx] <= target) {
            taken = solver(idx - 1, arr, target - arr[idx], dp);
        }
        return  dp[idx][target] = taken + notTaken;
    }

    public int perfectSum(int[] arr, int K) {
        int n = arr.length;
        // memoization
        Integer[][] dp = new Integer[n][K + 1];
        return solver(n - 1, arr, K, dp);
    }
}

public class CountSubsetWithSumk {
    
}
