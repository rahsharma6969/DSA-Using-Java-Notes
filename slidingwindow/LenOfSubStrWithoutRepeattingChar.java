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
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1); // because index starts from 0 and length from 1
            // reason behind right - left + 1 is that right and left are both inclusive indices of the current substring.
        }
        return maxLength;
    }
}

public class LenOfSubStrWithoutRepeattingChar {
    public static void main(String[] args) {
        
    }
}
