/*392. Is Subsequence
Solved
Easy
Topics
premium lock icon
Companies
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 */
class Solution {
    // time complexity: O(n + m)
    // space complexity: O(1)
   public boolean isSubsequence(String s, String t) {
       int i= 0, j = 0;

       while(i<= s.length() -1 && j<= t.length() -1){
        
        if(s.charAt(i) == t.charAt(j)){
            i++;
        }
        else{
            j++;
        }
       }
        return i == s.length();
    }
}

public class IsSubsequent {
    public static void main(String[] args) {
        
    }
}
