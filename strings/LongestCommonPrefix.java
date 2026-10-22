/*
14. Longest Common Prefix
Solved
Easy
Topics
premium lock icon
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings. */


import java.util.Arrays;
import java.util.*;

class Solution {

    // time complexity : O(n * m), where n is the number of strings and
    //  m is the length of the shortest string.
    //  In the worst case, we may have to compare all characters of all strings.
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i<strs.length; i++) {
            while(strs.indexof(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}


public class LongestCommonPrefix {
    
}
