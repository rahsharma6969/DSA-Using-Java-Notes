/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0. */
import java.util.Stack;


class Solution {
    public String removeKdigits(String num, int k) {
         Stack<Character> stack = new Stack<>();
        for(char digit : num.toCharArray()){
            while(!stack.isEmpty() && k > 0 && stack.peek() > digit){
                stack.pop();
                k--;
            }
            stack.push(digit);  
    }
    
    // Remove any remaining k digits from the end
    while(k > 0 && !stack.isEmpty()) {
        stack.pop();
        k--;
    }
    
    // Build result string
    StringBuilder sb = new StringBuilder();
    for(char c : stack) {
        sb.append(c);
    }
    
    // Remove leading zeros
    while(sb.length() > 1 && sb.charAt(0) == '0') {
        sb.deleteCharAt(0);
    }
    
    return sb.length() == 0 ? "0" : sb.toString();
   }
}

public class RemovekDigits {
    public static void main(String[] args) {
        
    }
}
