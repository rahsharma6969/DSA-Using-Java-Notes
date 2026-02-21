/*
387. First Unique Character in a String
Solved
Easy
Topics
premium lock icon
Companies
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"

Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

Input: s = "loveleetcode"

Output: 2
*/
import java.util.*;

class Solution {

    // time complexity: O(n) where n is the length of the string
     public int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        // calculate frequency of each character
        for(char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        } 

        for(char c : s.toCharArray()){
            if(freqMap.get(c) == 1){
                return s.indexOf(c);
            }
        }
        return -1;
    }

    // using queue and frequency array
    // time complexity: O(n) where n is the length of the string
    public int firstUniqCharUsingQueue(String s) {
        Queue<Character> queue = new LinkedList<>();
        int[] freq = new int[26];   // For lowercase letters

        for (char ch : s.toCharArray()) {

            // Increase frequency
            freq[ch - 'a']++;

            // Add to queue
            queue.offer(ch);

            // Remove repeating characters from front
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
        }

        if(queue.isEmpty()) return -1;
        return s.indexOf(queue.peek());
    }
}
public class FirstUniqueChar {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
}
