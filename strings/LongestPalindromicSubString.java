import binarySearchOnAnswer.Solution;

/**
 * Longest Palindromic Substring
Subscribe to TUF+

Hints
Company
Given a string s, return the longest palindromic substring in s.



A palindromic substring is a contiguous sequence of characters within the string that reads the same forward and backward.


Example 1

Input: s = "babad"

Output: "bab"

Explanation:

Both "bab" and "aba" are valid palindromic substrings of length 3. Return either.

Example 2

Input: s = "cbbd"

Output: "bb"

Explanation:

The longest palindrome is "bb" of length 2.
 * 
 */

class Solution {
    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // time complexity: O(n^2)
    // space complexity: O(1)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddLen = expandFromCenter(s, i, i);
            int evenLen = expandFromCenter(s, i, i + 1);
            int maxLen = Math.max(oddLen, evenLen);

            if (maxLen > end - start + 1) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }
}

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("babad"));
        System.out.println(sol.longestPalindrome("cbbd"));
        System.out.println(sol.longestPalindrome("a"));
    }
}
