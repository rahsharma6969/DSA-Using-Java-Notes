/*
131. Palindrome Partitioning
Solved
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
Output: [["a"]] */

import java.util.ArrayList;
import java.util.List;

class Solution {

    private boolean isPalindrome(String s) {
        int left = 0  , right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    } 
    
    private void helper(String s,  int idx,  List<String> path, List<List<String>> result) {
        
        if(idx == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = idx; i<s.length(); i++) {
            String sub = s.substring(idx, i+1);
            if(isPalindrome(sub)) {
                path.add(sub);
                helper(s, i+1, path, result);
                path.remove(path.size()-1);
            } 
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        
        if(n == 0) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        if(n ==1 ) {    
            path.add(s);
            result.add(path);
            return result;
        }
        helper(s , 0, path, result);
        return result;
        
        
    }
}


public class PalindromePartition {

    
}
