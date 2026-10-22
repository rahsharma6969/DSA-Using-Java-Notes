
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

    void helper(List<String> result, String path, int open ,int close, int n) {
      


        if(open == n && close == n) {
            result.add(path);
            return;
        }
        if(open < n) {
            helper(result , path + "(" , open + 1 , close , n);
        }
        if(close < open) {
            helper(result , path + ")" , open , close + 1 , n);
        }

    }


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result , "", 0 , 0 , n);
        return result;
        
    }
}


public class GenerateParenthesis {
    
}
