/*
76. Minimum Window Substring
Hard
Topics
premium lock icon
Companies
Hint
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 */
import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();

        // frequency of t
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int count = 0; // count of characters matched
        int left = 0, right = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(need.containsKey(ch)) {
                need.put(ch, need.get(ch) - 1);
                if(need.get(ch) >= 0) count++;
            }

            while(count == t.length()) {
                // update answer
                if(right == 0 || i - left + 1 < right - left + 1) {
                    right = i;
                }

                char leftChar = s.charAt(left);
                if(need.containsKey(leftChar)) {
                    need.put(leftChar, need.get(leftChar) + 1);
                    if(need.get(leftChar) > 0) count--;
                }
                left++;
            }
        }
        return right == 0 ? "" : s.substring(left, right + 1);
    }
}

public class MinWindowSubstring {
    
}
