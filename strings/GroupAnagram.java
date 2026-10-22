/*
49. Group Anagrams
Medium
Topics
premium lock icon
Companies
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

 */



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
    // brute force approach
    // Time complexity: O(n * k log k), where n is the number of strings and k is the maximum length of a string. Sorting each string takes O(k log k) time.
    // Space complexity: O(n * k), where n is the number of strings and k
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());

    }


    // optimzed approach
    // Time complexity: O(n * k), where n is the number of strings and k is the maximum length of a string. Counting the frequency of characters takes O(k) time.
    // Space complexity: O(n * k), where n is the number of strings and k is the maximum length of a string. The space used by the HashMap to store the grouped anagrams.
    public List<List<String>> groupAnagramsOptimized(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();


        for(String str : strs) {
            String frequencyString = getFrequencyString(str);

            if(map.containsKey(frequencyString)) {
                map.get(frequencyString).add(str);
            } else {
                map.put(frequencyString, new ArrayList<>());
                map.get(frequencyString).add(str);
            }
           
        }

        return new ArrayList<>(map.values());
    }

    private String getFrequencyString(String str) {
        int[] frequency = new int[26];

        for(char c : str.toCharArray()) {
            frequency[c - 'a']++;
        }

       char c = 'a';
       StringBuilder joiner = new StringBuilder();
        for(int i  : frequency) {
           joiner.append(c);
           joiner.append(i);
           c++;
        }
        return joiner.toString();
    }
}