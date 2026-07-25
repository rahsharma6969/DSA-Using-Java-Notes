
/*
Given string num representing a non-negative integer num, and an integer k,
 return the smallest possible integer after removing k digits from num.

 

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

        for (char c : num.toCharArray()) {

            while (!stack.isEmpty()
                    && k > 0
                    && stack.peek() > c) {

                stack.pop();
                k--;
            }

            stack.push(c);
        }

        // remove remaining digits
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        // remove leading zeros
        int i = 0;

        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String ans = sb.substring(i);

        return ans.length() == 0 ? "0" : ans;
    }
}

public class RemovekDigits {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String num = "1432219";
        int k = 3;
        String result = solution.removeKdigits(num, k);
        System.out.println(result); // Output: "1219"
    }
}