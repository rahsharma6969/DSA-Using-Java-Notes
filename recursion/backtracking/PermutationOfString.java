/* 
Permutations of a String
Subscribe to TUF+

Hints
Company
Given a string s, 
return all unique permutations of its characters in sorted order.

The output should be a list of strings, where each string is a valid permutation of s.
If the string contains duplicate characters, each permutation should appear only once.
The list should be sorted lexicographically.


You must return a list of strings, where each string is a valid permutation of s.


Example 1

Input: s = "abc"

Output: ["abc","acb","bac","bca","cab","cba"]

Explanation: All 6 permutations of 3 distinct characters.

Example 2

Input: s = "aab"

Output: ["aab","aba","baa"]

Explanation: Only 3 unique permutations due to duplicate 'a'*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public void helper(char[] arr, boolean[] used, StringBuilder curr, List<String> ans) {

        // Base case
        if (curr.length() == arr.length) {
            ans.add(curr.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            // Skip already used characters
            if (used[i]) {
                continue;
            }

            // Skip duplicates
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            curr.append(arr[i]);

            helper(arr, used, curr, ans);

            curr.deleteCharAt(curr.length() - 1);
            used[i] = false;
        }
    }

    public List<String> permuteUnique(String s) {

        List<String> ans = new ArrayList<>();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);           // Required for duplicate handling

        boolean[] used = new boolean[arr.length];
        StringBuilder curr = new StringBuilder();

        helper(arr, used, curr, ans);

        return ans;
    }
}
public class PermutationOfString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abc";
        List<String> result = sol.permuteUnique(s);
        System.out.println(result);

    }
}
