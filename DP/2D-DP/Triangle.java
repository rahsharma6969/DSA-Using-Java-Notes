/*
120. Triangle
Solved
Medium
Topics
premium lock icon
Companies
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, 
if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 */

import java.util.List;

class Solution {
    // recursive approach
    int calculate(int i, int j, List<List<Integer>> triangle, int n){
        if(i == n-1) return triangle.get(i).get(j);
        int d = triangle.get(i).get(j) + calculate(i+1, j, triangle, n);
        int dg = triangle.get(i).get(j) + calculate(i+1, j+1, triangle, n);
        return Math.min(d, dg);
        // return triangle.get(i).get(j) + Math.min(calculate(i+1, j, triangle, n), 
        // calculate(i+1, j+1, triangle, n));
    }
    public int minimum(List<List<Integer>> triangle) {
        int n = triangle.size();
        return calculate(0, 0, triangle, n);
    }

    // memoization approach
    int calculateMemo(int i, int j, List<List<Integer>> triangle, int n, int[][] dp){
        if(i == n-1) return triangle.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int d = triangle.get(i).get(j) + calculateMemo(i+1, j, triangle, n, dp);
        int dg = triangle.get(i).get(j) + calculateMemo(i+1, j+1, triangle, n, dp);
        return dp[i][j] = Math.min(d, dg);
    }
    int minimumTotalMemo(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return calculateMemo(0, 0, triangle, n, dp);
    }

    // space optimization approach
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for(int j = 0; j < n; j++){
            dp[j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                int d = triangle.get(i).get(j) + dp[j];
                int dg = triangle.get(i).get(j) + dp[j+1];
                dp[j] = Math.min(d, dg);
            }
        }
        return dp[0];
    }
}




public class Triangle {
    
}
