class Queue {
    int[] queue;
    int front, rear, capacity;

    Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
    }

    // Enqueue - Add element at rear
    void enqueue(int val) {
        if (rear == capacity - 1) {
            System.out.println("Queue is full");
            return;
        }
        queue[++rear] = val;
        System.out.println(val + " enqueued");
    }

    // Dequeue - Remove element from front
    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = queue[front]; // get front element
        front++;                // move front forward
        return val;
    }

    // Check if queue is empty
    boolean isEmpty() {
        return front > rear;
    }

    // Display the queue
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        q.display();
    }
}
