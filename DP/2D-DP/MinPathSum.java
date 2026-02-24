/* 64. Minimum Path Sum

Code
Testcase
Testcase
Test Result
64. Minimum Path Sum
Medium
Topics
premium lock icon
Companies
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right,
 which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
class Solution {

    public int calculate(int i, int j, int[][] grid) {
      if(i == 0 && j == 0) return grid[0][0];
      if(i < 0 || j<0) return (int)1e9; 

     return grid[i][j] + Math.min(calculate(i-1, j, grid), calculate(i, j-1, grid));
    }
    public int minPathSum(int[][] grid) {
         int m = grid.length; // row
         int n = grid[0].length; // col
         if(grid.length == 0) return 0;
         if(grid.length == 1) return grid[0][0];

       return calculate(m-1, n-1, grid);
      
    }
    // using memoization
      public int Calculate(int i, int j, int[][] grid, int[][] dp) {

        if (i == 0 && j == 0) return grid[0][0];

        if (i < 0 || j < 0) return (int)1e9;

        if (dp[i][j] != -1) return dp[i][j];

        int up = Calculate(i - 1, j, grid, dp);
        int left = Calculate(i, j - 1, grid, dp);

        dp[i][j] = grid[i][j] + Math.min(up, left);

        return dp[i][j];
    }

    public int MinPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);

        return calculate(m - 1, n - 1, grid, dp);
    }
}
public class MinPathSum {
    
}
