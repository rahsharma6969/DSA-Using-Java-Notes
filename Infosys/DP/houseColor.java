/*
# Paint Houses with Minimum Cost and Budget Constraint

There are N houses arranged in a straight line. Each house must be painted using one of C available colors.

The cost of painting the i-th house with the j-th color is given by `cost[i][j]`.

The following conditions must be satisfied:

1. Every house must be painted exactly one color.
2. No two adjacent houses can have the same color.
3. The total painting cost must not exceed the given budget `B`.

Your task is to determine the minimum total painting cost.

If it is impossible to paint all the houses within the given budget, print `-1`.

## Input Format

- The first line contains an integer `N`, the number of houses.
- The second line contains an integer `C`, the number of available colors.
- The third line contains an integer `B`, the maximum allowed budget.
- The next `N` lines each contain `C` integers, where the `j-th` integer in the `i-th` line represents the cost of painting house `i` with color `j`.

## Output Format

Print a single integer:

- The minimum total painting cost if it does not exceed `B`.
- Otherwise, print `-1`.
*/

class Solution {
    public int minCost(int N, int C, int B, int[][] cost) {
        if (C == 1 && N > 1) {
            return -1;
        }

        long[][] dp = new long[N][C];

        for (int j = 0; j < C; j++) {
            dp[0][j] = cost[0][j];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < C; j++) {
                long minCost = Long.MAX_VALUE;

                for (int k = 0; k < C; k++) {
                    if (k != j) {
                        minCost = Math.min(minCost, dp[i - 1][k]);
                    }
                }

                dp[i][j] = minCost + cost[i][j];
            }
        }

        long ans = Long.MAX_VALUE;

        for (int j = 0; j < C; j++) {
            ans = Math.min(ans, dp[N - 1][j]);
        }

        return ans <= B ? (int) ans : -1;
    }
}