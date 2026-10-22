/*

Code
Testcase
Testcase
Test Result
122. Best Time to Buy and Sell Stock II
Medium
Topics
premium lock icon
Companies
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.

Find and return the maximum profit you can achieve.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
 */

import java.util.Arrays;

class Solution {
    //  private int dfs(int day, boolean holding, int[] prices) {
    //     if (day == prices.length) {
    //         return 0;
    //     }
        
    //     // Option 1: do nothing today
    //     int skip = dfs(day + 1, holding, prices);
        
    //     int action;
    //     if (holding) {
    //         // Option 2: sell today
    //         action = prices[day] + dfs(day + 1, false, prices);
    //     } else {
    //         // Option 2: buy today
    //         action = -prices[day] + dfs(day + 1, true, prices);
    //     }
        
    //     return Math.max(skip, action);
    // }
    

    // memoization
    public int dfs(int day, boolean holding, int[] prices, int[][] memo) {
        if (day == prices.length) { 
            return 0;
        }

        if (memo[day][holding ? 1 : 0] != -1) {
            return memo[day][holding ? 1 : 0];
        }

        // Option 1: do nothing today
        int skip = dfs(day + 1, holding, prices, memo);

        int action;
        if (holding) {
            // Option 2: sell today
            action = prices[day] + dfs(day + 1, false, prices, memo);
        } else {
            // Option 2: buy today
            action = -prices[day] + dfs(day + 1, true, prices, memo);
        }

        memo[day][holding ? 1 : 0] = Math.max(skip, action);
        return Math.max(skip, action);
    }

    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, false, prices, memo);
    }
}


public class BuyAndSellStockII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit); // Output: Maximum Profit: 7
    }

        }

