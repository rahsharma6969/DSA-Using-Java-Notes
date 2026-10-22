import java.util.Arrays;

class Solution {
    // tabulation approach is used here
    public int knapsack(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W + 1];

        for (int i = 0; i < n; i++) {
            for (int capacity = 0; capacity <= W; capacity++) {
                if (i == 0) {
                    if (wt[0] <= capacity) {
                        dp[i][capacity] = val[0];
                    } else {
                        dp[i][capacity] = 0;
                    }
                } else {
                    int notTake = dp[i - 1][capacity];

                    int take = 0;
                    if (wt[i] <= capacity) {
                        take = val[i] + dp[i - 1][capacity - wt[i]];
                    }

                    dp[i][capacity] = Math.max(notTake, take);
                }
            }
        }

        return dp[n - 1][W];
    }
} 



class SolutionMemo {
    int[][] dp;

    int solve(int idx, int[] wt, int[] val, int W) {
        if (idx == 0) {
            if (wt[0] <= W) return val[0];
            return 0;
        }

        if (dp[idx][W] != -1) return dp[idx][W];

        int notTake = solve(idx - 1, wt, val, W);
        int take = Integer.MIN_VALUE;

        if (wt[idx] <= W) {
            take = val[idx] + solve(idx - 1, wt, val, W - wt[idx]);
        }

        return dp[idx][W] = Math.max(notTake, take);
    }

    public int knapsack(int[] wt, int[] val, int n, int W) {
        dp = new int[n][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n - 1, wt, val, W);
    }
}
public class knapsack {
    public static void main(String[] args) {
        
    }
}
