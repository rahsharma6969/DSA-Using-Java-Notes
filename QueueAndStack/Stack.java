
import java.util.Arrays;

class stack {
    int top; // to track the top index of the stack
    int capacity;
    int [] stackArr;

    public stack(int size){
        this.capacity = size;
        this.stackArr = new int[size];
        this.top = -1;
    }

    // push operation
    public void push(int val){
        if(top == capacity - 1){
            System.out.println("Stack Overflow");
        } else {
            top++;
            stackArr[top] = val;
        }
    }

    // pop operation
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int val = stackArr[top];
            top--;
            return val;
        }
    }

    // stack top
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stackArr[top];
        }
    }

    // check if stack is empty
    public boolean isEmpty(){
        return top == -1;
    }

    // if stack is full
    public boolean isFull(){
        return top == capacity - 1;
    }
}




public class Stack {
    public static void main(String[] args) {
        
    }
}
