/*
Longest Substring with K Uniques
Difficulty: MediumAccuracy: 34.65%Submissions: 281K+Points: 4
You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

Note : If no such substring exists, return -1. 

Examples:

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters. */

import java.util.HashMap;

class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int left = 0 ;
        int maxLen = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int right =0; right< s.length(); right++){
            char ch = s.charAt(right);
            map.put(ch , map.getOrDefault(ch , 0) + 1);
            
             while(map.size() > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }

                left++;
            }

            if(map.size() == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
}
public class LongestSubStringWithKUniques {
    
}
