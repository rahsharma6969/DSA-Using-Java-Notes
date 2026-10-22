 /*
 322. Coin Change
Solved
Medium
Topics
premium lock icon
Companies
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 */

import java.util.Arrays;
class Solution {

    private static final int INF = Integer.MAX_VALUE / 4; // to avoid overflow when adding 1
    // private int helper(int[] coins , int amount, int idx) {
    //     if(idx < 0) {
    //         return INF;
    //     }
    //     if (amount < 0) {
    //         return INF;
    //     }
    //     if( amount == 0 ) {
    //         return 0;
    //     }
 
    //     int take = 1 + helper(coins , amount - coins[idx] , idx );
       
       
    //     int not_take = helper(coins , amount , idx - 1);
        
    //     return Math.min(take, not_take);
        
    // }

    // public int coinChange(int[] coins, int amount) {
    //     if(amount == 0) return 0;
    //     int n = coins.length;
    //     int result = helper(coins , amount, n - 1);
    //     return result == INF ? -1 : result;
    // }

    // memoization approach
    private int helper(int[] coins , int amount, int idx, int[][] dp) {
        
        if(idx < 0) {
            return INF;
        }
        if (amount < 0) {
            return INF;
        }
        if( amount == 0 ) {
            return 0;
        }

        if(dp[idx][amount] != -1) return dp[idx][amount];

        int take = 1 + helper(coins , amount - coins[idx] , idx, dp );
       
       
        int not_take = helper(coins , amount , idx - 1, dp);
        
        return dp[idx][amount] = Math.min(take, not_take);
        
    }
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result = helper(coins , amount, n - 1, dp);
        return result == INF ? -1 : result;
    }
}
public class CoinChange {
    
}
