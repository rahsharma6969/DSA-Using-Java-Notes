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
import java.util.HashMap;
import java.util.Map;

class Solution {
    // time complexity is O(n) and space complexity is O(n)
    public int lengthOfLongestSubstring0(String s) {
       int maxLen = 0;
       int left = 0;

       HashSet<Character> set = new HashSet<>();

       for(int right = 0; right < s.length(); right++){
        char curr = s.charAt(right);
           while(set.contains(curr)){
               set.remove(s.charAt(left));
               left++;
           }
            set.add(curr);
            maxLen = Math.max(maxLen, right - left + 1);
       }
       return maxLen;

    }
    // time complexity is O(n) and space complexity is O(n)
    public int lengthOfLongestSubstring(String s) {
      int left =0, maxlen = 0;
      Map<Character , Integer> map = new HashMap<>();

      for(int right=0; right< s.length(); right++) {
        char curr = s.charAt(right);

        while(map.containsKey(curr)) {
            left++;
            if(left > map.get(curr)) {
                map.remove(curr);
                break;
            }
        }
        map.put(curr, right); 
        maxlen = Math.max(maxlen , right - left + 1 );
      }
        
    return maxlen;
    }
}

public class LenOfSubStrWithoutRepeattingChar {
    public static void main(String[] args) {
        
    }
}
