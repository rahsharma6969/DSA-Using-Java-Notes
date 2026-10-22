package DP.String;
/*
1143. Longest Common Subsequence
Medium
Topics
premium lock icon
Companies
Hint
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

*/
class Solution {
    public int lcs(String t1 , String t2 , int n , int m, int [][] dp) {
        if( n < 0 || m < 0) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        if(t1.charAt(n) == t2.charAt(m)) {
            dp[n][m] = 1 + lcs(t1 , t2 , n - 1 , m - 1, dp);
            return dp[n][m];
        }
        return  dp[n][m] = Math.max(lcs(t1 , t2 , n - 1 , m, dp) , lcs(t1 , t2 , n , m - 1, dp));
  
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return lcs(text1, text2, n - 1, m - 1, dp);
    }

    public int longestCommonSubsequenceTab(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        // dp[i][j] = LCS of text1[0..i-1] and text2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];
        
        // dp[0][j] = 0 and dp[i][0] = 0 are already 0 by default in Java
        // (this IS the base case — empty string has LCS 0 with anything)
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[n][m];
    }
}
public class LongestCommonSubString {
    public static void main(String[] args) {
        Solution s = new Solution();
        String text1 = " ABCDGH";
        String text2 = "ACDGHR";
        System.out.println(s.longestCommonSubsequence(text1, text2));

     
        
    }
}
