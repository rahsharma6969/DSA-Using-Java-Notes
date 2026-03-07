/*
931. Minimum Falling Path Sum
Medium
Topics
premium lock icon
Companies
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element 
in the next row that is either directly below or diagonally left/right.
Specifically, the next element from position 
(row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1). 

Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.*/

// Note : This problem is similar to triangle problem 
import java.util.Arrays;
import java.util.*;

class Solution {

    // recursive approach
    int calculate(int i, int j, int [][] matrix, int n){
        if(i == n-1) return matrix[i][j];
        if(j < 0 || j>= n) return Integer.MAX_VALUE;
        int d = matrix[i][j] + calculate(i+1,j,matrix, n);
        int  dl = matrix[i][j] + calculate(i+1, j-1, matrix, n);
        int dr = matrix[i][j] + calculate(i+1, j+1, matrix,n);

        return Math.min(d,Math.min(dr,dl));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; // as it is a square matrix
        if(matrix.length == 0) return 0;
        if(matrix.length == 1) return matrix[0][0];
        int minSum = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            minSum = Math.min(minSum, calculate(0, j, matrix, n)); // we are sending n 
        }
        return minSum;
        
    }
    //using memoization
    int[][] dp;

    int Calculate(int i, int j, int[][] matrix, int n){
        if(j < 0 || j >= n) return Integer.MAX_VALUE;
        if(i == n-1) return matrix[i][j];

        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int d  = Calculate(i+1, j, matrix, n);
        int dl = Calculate(i+1, j-1, matrix, n);
        int dr = Calculate(i+1, j+1, matrix, n);

        return dp[i][j] = matrix[i][j] + Math.min(d, Math.min(dl, dr));
    }

    public int MinFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        dp = new int[n][n];
        for(int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        int minSum = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++){
            minSum = Math.min(minSum, Calculate(0, j, matrix, n));
        }

        return minSum;
    }
}
public class MinimumFallingPath {
    
}
