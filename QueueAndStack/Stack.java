
// stack.push(1);
// int top = stack.peek(); // top element
// int pooped = stack.pop(); // remove top element
class ArrayStack {
    int size;
    int top;
    int[] stack;
    int capacity = 1000 ;

    ArrayStack() {
        this.size = 0;
        this.top = -1;
        this.stack = new int[capacity];
    }

    void push(int x) {
        if(this.size == capacity) return;
        this.top++;
        this.stack[this.top] = x;
        this.size++;
    }

    int pop() {
        if(isEmpty()) return -1;
        int topElement = this.stack[this.top];
        this.top--;
        this.size--;
        return topElement;
    }

    int peek() {
        if(isEmpty()) return -1;
        return this.stack[this.top];
    }

    boolean isEmpty() {
        return this.size ==0;
    }
} 




public class Stack {
    public static void main(String[] args) {
        

        
        
    }
}
