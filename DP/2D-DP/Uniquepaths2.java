/*63. Unique Paths II
Medium
Topics
premium lock icon
Companies
Hint
You are given an m x n integer array grid. There is a robot initially located 
at the top-left corner (i.e., grid[0][0]). 
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. 
A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

*/



class Solution {
    // time complexity is O(m*n) and space complexity is O(m*n)
    public int solve(int i, int j, int[][] grid, int[][] dp) {

        if (i < 0 || j < 0) return 0;

        if (grid[i][j] == 1) return 0;

        if (i == 0 && j == 0) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        int up = solve(i - 1, j, grid, dp);
        int left = solve(i, j - 1, grid, dp);

        dp[i][j] = up + left;
        return dp[i][j];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);

        return solve(m - 1, n - 1, obstacleGrid, dp);
    }
}
public class Uniquepaths2 {
    public static void main(String[] args) {
        int m = 3, n = 7;
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
       
       
    }
}
