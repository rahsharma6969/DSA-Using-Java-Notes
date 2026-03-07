/*  62. Unique Paths
Medium
Topics
premium lock icon
Companies
There is a robot on an m x n grid. 
The robot is initially located at the top-left corner (i.e., grid[0][0]).
 The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
 The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the 
robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
*/


class Solution {

     

    // recursive approach
    public int uniquePaths(int m, int n) {

        if(  n == 1 || m == 1)
            return 1;
        if( n <= 0 || m <= 0){ // this is not a square matrix so we have to check for both m & n but for 
            return 0;
        }
        int up = uniquePaths(m-1, n);
        int left = uniquePaths(m, n-1);
        return up + left;
    }

    // memoization approach
    public int UniquePaths(int m, int n, int[][] dp) {

        if(  n == 1 || m == 1)
            return 1;

        if(dp[m][n] != -1)
            return dp[m][n];

        int up = UniquePaths(m-1, n, dp);
        int left = UniquePaths(m, n-1, dp);
        return dp[m][n] = up + left;
    }

     // tabulation approach
     public int UniquePaths(int m, int n) {

        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(i == 1 || j == 1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m][n];
    }
}
public class Uniquepaths {
    public static void main(String[] args) {
        
    }
}
