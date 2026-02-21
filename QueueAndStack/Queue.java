public class Queue {
    int front , rear , size;
    int capacity;
    int [] queueArr;
    public Queue(int size){ /// constructor to initialize the queue
        this.capacity = size;
        this.queueArr = new int[size];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // enqueue operation for normal queue
    public void enqueue(int val){
        if(size == capacity){
            System.out.println("Queue is full");
        } else {
            rear += 1;
            rear = rear % capacity; // circular increment
            queueArr[rear] = val;
        }
    }

    // dequeue operation
    public int dequeue(){
        if(size == 0){
            System.out.println("Queue is empty");
            return -1;
        } else {
            int val = queueArr[front];
            front = (front + 1) % capacity; // circular increment
            size--;
            return val;
        }
    }
    
    // display operation
    public void display(){
        if(size == 0){
            System.out.println("Queue is empty");
        } else {
            int i = front;
            for(int j = 0; j < size; j++){
                System.out.print(queueArr[i] + " ");
                i = (i + 1) % capacity;
            }
            System.out.println();
        }
    }
    
}
