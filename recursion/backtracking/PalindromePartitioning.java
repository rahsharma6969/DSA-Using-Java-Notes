
/*
131. Palindrome Partitioning
Medium
Topics
premium lock icon
Companies
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 */
 import java.util.*;
 import java.util.List;

class Solution {

    boolean isPalindrome(String s , int start, int end) {

        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }   

    public void backtracking(String s , int start , List<String> path , List<List<String>> result) {
         

        // base case
        if(start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }


        for(int i=start ; i<s.length() ; i++) {
            if(isPalindrome(s , start , i)) {
                path.add(s.substring(start , i + 1));
                backtracking(s , i + 1 , path , result);
                path.remove(path.size() - 1); // Backtrack
            }
        }
    } 
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtracking(s , 0 , path , result);
        return result;
    }
}

public class PalindromePartitioning {
    
}
