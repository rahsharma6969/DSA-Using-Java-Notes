/*
20. Valid Parentheses
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false */
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
public class validParenthisis {

    static boolean isValid(String s){
        Stack<Character> stack = new Stack();
      
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    static boolean isValid2(String s){

        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                if(stack.isEmpty() || stack.pop() != map.get(ch)){
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid2("()[]{}")); // true
        System.out.println(isValid2("(]"));     // false
    
    }
}
