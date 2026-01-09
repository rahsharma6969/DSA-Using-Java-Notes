class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Queue{

    Node front, rear;
    int size;
    public Queue(){
        this.front = this.rear = null;
        this.size = 0;
    }
    void enqueue(int data){
        Node newNode = new Node(data);
        if(this.rear == null){
            this.front = this.rear = newNode;
        }
        else{
             this.rear.next = newNode;
             this.rear = newNode;
            
        }
        size++;
        
    }

    int dequeue(){
        if(this.front == null){
            System.out.println("Queue is empty");
            return -1;
        }
        Node nodetoDel = this.front;
        this.front = this.front.next;
        if(this.front == null){
            this.rear = null;
        }
        size--;
        return nodetoDel.data;
    }


}


public class QueueLL {
    public static void main(String[] args) {
        
    }
}
