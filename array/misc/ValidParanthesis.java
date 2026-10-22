import com.sun.jdi.PathSearchingVirtualMachine;
import java.util.*;

public class ValidParanthesis {

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    return false; // Mismatched brackets
                }
            }
        }

        return stack.isEmpty(); // If stack is empty, all brackets were matched
    }
    public static void main(String[] args) {
        String s = "{[(]]}";
        System.out.println(isValid(s)); // Output: true
        
    }
}
