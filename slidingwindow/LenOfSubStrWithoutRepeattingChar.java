/*
3. Longest Substring Without Repeating Characters

Medium
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1. */

import java.util.HashSet;
class Solution {
    public int lengthOfLongestSubstring(String s) {
       int maxLen = 0;
       int left = 0;

       HashSet<Character> set = new HashSet<>();

       for(int right = 0; right < s.length(); right++){
        char currentchar = s.charAt(right);
           while(set.contains(currentchar)){
               set.remove(s.charAt(left));
               left++;
           }
            set.add(currentchar);
            maxLen = Math.max(maxLen, right - left + 1);
       }
       return maxLen;

    }
}

public class LenOfSubStrWithoutRepeattingChar {
    public static void main(String[] args) {
        
    }
}
