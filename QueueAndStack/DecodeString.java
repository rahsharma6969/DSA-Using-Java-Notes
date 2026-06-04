/* 

394. Decode String
Medium
Topics
premium lock icon
Companies
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

*/

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
       String currentString = "";
       int currentNum = 0;

       for(char c : s.toCharArray()) {
        // If the character is a digit, we need to calculate the full number (which could be more than one digit)
        if(Character.isDigit(c)) {
            currentNum = currentNum * 10 + (c - '0');
        } else if(c == '[') {
            stringStack.push(currentString);
            currentString = "";
        } else if(c == ']') {
            StringBuilder sb = new StringBuilder();
            sb.append(stringStack.pop());
            int repeatTimes = numberStack.pop();
            for(int i = 0; i < repeatTimes; i++) {
                sb.append(currentString);
            }
            currentString = sb.toString();
        } else {
            currentString += c;
        }
       }
       return currentString;
    }
}
public class DecodeString {
    
}
