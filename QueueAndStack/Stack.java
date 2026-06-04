
import java.util.Arrays;

class Stack {
    int[] stack;
    int top;
    int capacity;

    Stack(int size) {
        this.stack = new int[size];
        this.capacity = size;
        this.top = -1; // bez element in stack is represented by top = -1
    }

    void push (int x) {
        if(top == capacity - 1) {
            System.out.println("Stack overflow");
            
        } 
        stack[++top] = x;
      
    }

    void pop() {
        if (top == -1) {          
            System.out.println("Stack underflow");
        } else {
            int x = stack[top];
            top--;
            System.out.println("Popped element: " + x);
        }
    }

    int top () {
        if(top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top];
        }
    }

    boolean isFull() {
        return top == capacity - 1;
    }
    boolean isEmpty() {
        return top == -1;
    }
}




public class Stack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Top element: " + stack.top());
        stack.pop();
        System.out.println("Top element after pop: " + stack.top());

        
        
    }
}
