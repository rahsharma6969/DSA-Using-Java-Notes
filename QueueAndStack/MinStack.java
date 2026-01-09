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
    private  Stack<Integer> stack = new Stack<>(); // main stack
    private Stack<Integer> minStack = new Stack<>();  // stack to keep track of minimums

     public void minStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        
    }
    
     public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }

    }
    
    public void pop() {
        if(!stack.isEmpty()){
            int poppedVal = stack.pop();
            if(poppedVal == minStack.peek()){
                minStack.pop();
            }

        }
        
    }
    
    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return -1;
        
    }
    
    public  int getMin() {
        if(!minStack.isEmpty()){
          return minStack.peek();
        }

        return -1;   
        
    }
    public static void main(String[] args) {
        
    }
}
