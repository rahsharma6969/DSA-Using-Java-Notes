/*
 * 155. Min Stack
Solved
Medium
Topics
premium lock icon
Companies
Hint
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
*/

import java.util.Stack;
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private  Stack<Integer> minstack = new Stack<>();
     public MinStack() {
      stack = new Stack<>();
      minstack = new Stack<>();
        
    }

     public void push(int val) {
      stack.push(val);
      if(minstack.isEmpty() || minstack.peek() >= val){
        minstack.push(val);
      }
    }
    
    public void pop() {
      if(stack.isEmpty()) return;
        int top = stack.pop();
        if(top == minstack.peek()) minstack.pop();

        
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek();     
    }
    
    public  int getMin() {
        if(minstack.isEmpty()) return -1;
        return minstack.peek();
      
    }
    

    public static void main(String[] args) {
        
    }

}