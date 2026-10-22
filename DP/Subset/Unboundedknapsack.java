/*
Unbounded knapsack
Subscribe to TUF+

Hints
Company
Given two integer arrays, val and wt, each of size N, representing the values and weights of N items respectively, and an integer W, representing the maximum capacity of a knapsack, determine the maximum value achievable by selecting a subset of the items such that the total weight of the selected items does not exceed the knapsack capacity W. The goal is to maximize the sum of the values of the selected items while keeping the total weight within the knapsack's capacity.



An infinite supply of each item can be assumed.


Example 1

Input: val = [5, 11, 13], wt = [2, 4, 6], W = 10

Output: 27

Explanation: Select 2 items with weights 4 and 1 item with weight 2 for a total value of 11+11+5 = 27.

Example 2

Input: val = [10, 40, 50, 70], wt = [1, 3, 4, 5], W = 8

Output: 110

Explanation: Select items with weights 3 and 5 for a total value of 40 + 70 = 110. */


import java.util.Arrays;

class Solution {

    // brute force approach

    // int solve(int idx , int wt[], int[] val, int W) {

    //     if(idx == 0) {
    //       if(wt[0] <= W) return (W / wt[0]) * val[0];
    //       else return 0;
    //     }
    //     int not_taken = solve(idx - 1, wt, val, W);
    //     int taken = Integer.MIN_VALUE;
    //     if(wt[idx] <= W) {
    //         taken = val[idx] + solve(idx, wt , val, W - wt[idx]);
    //     }

    //     return Math.max(not_taken, taken);
    // }

    // memoization approach
    int solve(int idx, int[] wt, int[] val, int W, int[][] dp) {
        if (idx == 0) {
            if (wt[0] <= W) return (W / wt[0]) * val[0];
            return 0;
        }

        if (dp[idx][W] != -1) return dp[idx][W];

        int notTake = solve(idx - 1, wt, val, W, dp);
        int take = Integer.MIN_VALUE;

        if (wt[idx] <= W) {
            take = val[idx] + solve(idx, wt, val, W - wt[idx], dp);
        }

        return dp[idx][W] = Math.max(notTake, take);
    }
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
       int[][] dp = new int[n][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        if(n == 0 || W == 0) return 0;
        if( n == 1 && wt[0] <= W) return (W / wt[0]) * val[0];

        return solve(n - 1, wt, val, W, dp);
    }
}
