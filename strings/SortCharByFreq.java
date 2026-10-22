/*
451. Sort Characters By Frequency
Medium
Topics
premium lock icon
Companies
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
  */

import java.util.*;

class Solution {

    // time complexity: O(n log n) where n is the length of the string
    // space complexity: O(n) for the frequency map and the result string
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Character> charList = new ArrayList<>(freqMap.keySet());
        Collections.sort(charList, (a, b) -> freqMap.get(b) - freqMap.get(a));

        StringBuilder result = new StringBuilder();

        for (char ch : charList) { // O(n)
            int count = freqMap.get(ch); 
            for (int i = 0; i < count; i++) { // O(n) in total for all characters
                result.append(ch);
            }
        }

        return result.toString();
    }
}


public class SortCharByFreq {
    
}
