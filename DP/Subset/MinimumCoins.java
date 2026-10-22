/*
Minimum coins
Subscribe to TUF+

Hints
Company
Given an integer array of coins representing coins of different
denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that are needed to make up that amount. 
If that amount of money cannot be made up by any combination of the coins,
return -1. There are infinite numbers of coins of each type


Example 1

Input: coins = [1, 2, 5], amount = 11

Output: 3

Explanation: 11 = 5 + 5 + 1. We need 3 coins to make up the amount 11.

Example 2

Input: coins = [2, 5], amount = 3

Output: -1

Explanation: It's not possible to make amount 3 with coins 2 and 5. Since we can't combine the coin 2 and 5 to make the amount 3, the output is -1.

Now your turn!

Input: coins = [10], amount = 5

Output:

Pick your answer */

import java.util.Arrays;
class Solution {
    private static final int INF = Integer.MAX_VALUE / 4;

    // returns min coins to make 'amount' using coins[0..idx], or INF if impossible
    // time complexity: O(n * amount), space complexity: O(n * amount)
    public int solve(int idx, int[] coins, int amount, int[][] dp) {
        if (amount == 0) return 0;
        if (idx == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            return INF;
        }

        if (dp[idx][amount] != -1) return dp[idx][amount];

        // don't take current coin
        int notTake = solve(idx - 1, coins, amount, dp);

        // take current coin (if possible) — note the +1 for using one coin
        int take = INF;
        if (coins[idx] <= amount) {
            take = 1 + solve(idx, coins, amount - coins[idx], dp);
        }

        return dp[idx][amount] = Math.min(notTake, take);
    }

    public int MinimumCoins(int[] coins, int amount) {
        int n = coins.length;
        if (amount == 0) return 0;
        if (n == 0) return -1;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = solve(n - 1, coins, amount, dp);
        return ans >= INF ? -1 : ans;
    }

    // tabulation approach
    // time complexity: O(n * amount), space complexity: O(n * amount)
    public int MinimumCoinsTabulation(int[] coins, int amount) {
        int n = coins.length;
        if (amount == 0) return 0;
        if (n == 0) return -1;

        int[][] dp = new int[n][amount + 1];

        // base case for amount = 0
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        // base case for idx = 0
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            } else {
                dp[0][j] = INF;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                int notTake = dp[i - 1][j];
                int take = INF;
                if (coins[i] <= j) {
                    take = 1 + dp[i][j - coins[i]];
                }
                dp[i][j] = Math.min(notTake, take);
            }
        }

        return dp[n - 1][amount] >= INF ? -1 : dp[n - 1][amount];
    }
}

public class MinimumCoins {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println(solution.MinimumCoins(coins1, amount1)); // Output: 3

        int[] coins2 = {2, 5};
        int amount2 = 3;
        System.out.println(solution.MinimumCoins(coins2, amount2)); // Output: -1

        int[] coins3 = {10};
        int amount3 = 5;
        System.out.println(solution.MinimumCoins(coins3, amount3)); // Output: -1
    }
}
