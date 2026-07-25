
/*
Generate Parentheses
Subscribe to TUF+

Hints
Company
Given an integer n.Generate all possible combinations of well-formed parentheses of length 2 x N.


Example 1

Input : n = 3

Output : [ "((()))" , "(()())" , "(())()" , "()(())" , "()()()" ]

Example 2

Input : 2

Output : [ "(())" , "()()" ]

*/
import java.util.*;

class Solution {

    public void helper(int n, int open , int close , StringBuilder sb , List<String> result) {
        if(open == n && close == n) {
            result.add(sb.toString());
            return;
        }
        if(open < n) {
            sb.append("(");
            helper(n , open + 1 , close , sb , result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open) {
            sb.append(")");
            helper(n , open , close + 1 , sb , result);
            sb.deleteCharAt(sb.length() - 1);
        }

        
    }
    public List<String> generateParenthesis(int n) {
        //your code goes here
        if(n == 0) {
            return new ArrayList<>();
        }
        if( n== 1) {
            return Arrays.asList("()");
        }

        List<String> result = new ArrayList<>();
        helper(n,0 , 0 , new StringBuilder() , result);
        return result;
    }
}


public class GenerateParenthesis {
    
}
