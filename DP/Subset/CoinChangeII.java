/*
518. Coin Change II
Medium
Topics
premium lock icon
Companies
You are given an integer array coins representing coins of different
denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. 
If that amount of money cannot be made up by any combination of the coins, 
return 0.

You may assume that you have an infinite number of each kind of coin.

The final answer is guaranteed to fit into a signed 32-bit integer.

 

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1 */   

import java.util.Arrays;
class Solution {
    int solve(int idx , int[] coins, int target) {
        if(target == 0) return 1;
        if(idx == 0) {
            if(target % coins[0] == 0) return 1;
            else return 0;
        }

        int notTake = solve(idx - 1, coins, target);
        int take = 0;
        if(coins[idx] <= target) {
            take = solve(idx, coins, target - coins[idx]);
        }
        return notTake + take;
    }
    // memoization approach
    int solve(int idx , int[] coins, int target, int[][] dp) {
        if(target == 0) return 1;
        if(idx == 0) {
            if(target % coins[0] == 0) return 1;
            else return 0;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int notTake = solve(idx - 1, coins, target, dp);
        int take = 0;
        if(coins[idx] <= target) {
            take = solve(idx, coins, target - coins[idx], dp);
        }
        return dp[idx][target] = notTake + take;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n - 1, coins, amount);
    }
}



public class CoinChangeII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int amount = 5;
        int[] coins = {1, 2, 5};
        int result = sol.change(amount, coins);
        System.out.println(result); // Output: 4
    }
}
