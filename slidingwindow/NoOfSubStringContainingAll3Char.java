/*
1358. Number of Substrings Containing All Three Characters
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters
a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", 
"bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
  */
import java.util.HashMap;
import java.util.Map;


class Solution {
    public int numberOfSubstrings(String s) {

        int left = 0;
        int count = 0;
        int[] freq = new int[3]; // a,b,c

        for(int right = 0; right < s.length(); right++){

            freq[s.charAt(right) - 'a']++;

            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){

                count += s.length() - right;

                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }

    public int numberOfString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        int count = 0;
        for(int right=0; right < s.length(); right++) {
            char curr = s.charAt(right);
            map.put(curr, map.get(curr) + 1);

            while(map.get('a') > 0 && map.get('b') > 0 && map.get('c') > 0) {
                count += s.length() - right;
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
        }
        return count;
    }
}
public class NoOfSubStringContainingAll3Char {
    
}
