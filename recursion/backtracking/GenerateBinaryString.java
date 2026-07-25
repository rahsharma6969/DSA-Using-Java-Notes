/*
Generate Binary Strings Without Consecutive 1s
Subscribe to TUF+

Hints
Company
Given an integer n, return all binary strings of length n
that do not contain consecutive 1s. Return the result in lexicographically 
increasing order.



A binary string is a string consisting only of characters '0' and '1'.


Example 1

Input: n = 3

Output: ["000", "001", "010", "100", "101"]

Explanation: All strings are of length 3 and do not contain consecutive 1s.

Example 2

Input: n = 2

Output: ["00", "01", "10"]
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void solver(int n , StringBuilder str, List<String> ans) {

        if(str.length() == n) {
            ans.add(str.toString());
            return;
        }

        for(int i=0 ; i<2; i++) {
            if(i == 1 && str.length() > 0 && str.charAt(str.length() - 1) == '1') {
                continue;
             }
            str.append(i);
             solver(n , str, ans);
            str.deleteCharAt(str.length() - 1);
        }
    }
    public List<String> generateBinaryStrings(int n) {
        // Your code goes here
      StringBuilder str = new StringBuilder();
      List<String> ans = new ArrayList<>();
      solver(n , str , ans);
      return ans;
    }
}
public class GenerateBinaryString {
    
}
