
/*Sort a Stack
Subscribe to TUF+

Hints
Company
You are given a stack of integers. 
Your task is to sort the stack in descending order using recursion, 
such that the top of the stack contains the greatest element. 
You are not allowed to use any loop-based sorting methods 
(e.g., quicksort, mergesort). 
You may only use recursive operations and 
the standard stack operations (push, pop, peek/top, and isEmpty).


Example 1

Input: stack = [ 1, 3, 2]

Output: [3, 2, 1]

Explanation:

After sorting, the largest element (3) is at the top, and the smallest (1) is at the bottom.



Example 2

Input: stack = [1]

Output: [1]

Explanation:

A single-element stack is already sorted. */
import java.util.Stack;

class Solution {
    private void insertInSortedOrder(Stack<Integer> st, int value) {
        if (st.isEmpty() || st.peek() < value) {
            st.push(value);
            return;
        }

        int temp = st.pop();
        insertInSortedOrder(st, value);
        st.push(temp);
    }

    public void sortStack(Stack<Integer> st) {
        if (st.size() <= 1) {
            return;
        }

        int top = st.pop();
        sortStack(st);
        insertInSortedOrder(st, top);
    }
}

public class SortStack {
}
