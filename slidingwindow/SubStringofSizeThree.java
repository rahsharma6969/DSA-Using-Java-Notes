/*
1876. Substrings of Size Three with Distinct Characters
Easy
Topics
premium lock icon
Companies
Hint
A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: s = "xyzzaz"
Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".
 */

class Solution{
    private boolean isGoodSubstring(String substring){
        return (substring.charAt(0) != substring.charAt(1)) &&
               (substring.charAt(1) != substring.charAt(2)) &&
               (substring.charAt(0) != substring.charAt(2));
    }
    public int countGoodSubStrings(String s){
        int count = 0;

        int n = s.length();

        for(int i=0; i<= n-3; i++){  // time complexity: O(n)
            String substring = s.substring(i, i+3);
            if(isGoodSubstring(substring)){
                count++;
            }
        }

        return count;
    }
}


public class SubStringofSizeThree {
    
}
