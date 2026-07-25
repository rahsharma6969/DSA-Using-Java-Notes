/*
Reverse a Stack
Subscribe to TUF+

Hints
Company
You are given a stack of integers.
Your task is to reverse the stack using recursion. 
ou may only use standard stack operations (push, pop, top/peek, isEmpty). 
You are not allowed to use any loop constructs or additional data structures 
like arrays or queues.



Your solution must modify the input stack in-place to reverse the order of its elements.


Example 1

Input: stack = [4, 1, 3, 2]

Output: [2, 3, 1, 4]

Example 2

Input: stack = [10, 20, -5, 7, 15]

Output: [15, 7, -5, 20, 10] */
import java.util.Stack;
import java.util.*;


class Solution {

    public void solver(Stack<Integer> st, int top) {
        if (st.isEmpty()) {
            st.push(top);
            return;
        }

        int temp = st.pop();
        solver(st, top);
        st.push(temp);
    }

    public void reverseStack(Stack<Integer> st) {
        if (st.isEmpty() || st.size() == 1) {
            return;
        }

        int top = st.pop();
        reverseStack(st);
        solver(st, top);
    }
}

public class ReverseStack {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(1);
        st.push(3);
        st.push(2);

        System.out.println("Before: " + st);
        sol.reverseStack(st);
        System.out.println("After: " + st);
    }
}