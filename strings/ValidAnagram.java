/*
242. Valid Anagram

Easy

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false
*/

import java.util.*;
 
public class ValidAnagram {

    // s is Anagram of t if all char counts are same in both strings
    // time complexity: O(n)
    // space complexity: O(n)
     static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> S_Map = new HashMap<>();
        for(char c: s.toCharArray()){
            S_Map.put(c, S_Map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> T_Map = new HashMap<>();
        for(char c: t.toCharArray()){
            T_Map.put(c, T_Map.getOrDefault(c, 0) + 1);
        }
        return S_Map.equals(T_Map);

        
    }

    // alternative approach using single hashmap
    // time complexity: O(n)
    // space complexity: O(n)
    static boolean isAnagramOptimized(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        for(char c: s.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for(char c: t.toCharArray()){
            if(!charCountMap.containsKey(c)){
                return false;
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if(charCountMap.get(c) == 0){
                charCountMap.remove(c);
            }
        }

        return charCountMap.isEmpty();
    }
    public static void main(String[] args) {
        
    }
}
