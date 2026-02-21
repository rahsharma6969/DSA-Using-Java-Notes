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

    int front(){
        if(this.front == null){
            System.out.println("Queue is empty");
            return -1;
        }
        return this.front.data;
    }

    void display(){
        if(this.front == null){
            System.out.println("Queue is empty");
        } else {
           Node temp = this.front;
           while(temp != null){
            System.out.println(temp.data + " >");
            temp = temp.next;
           }
        }
    }


}


public class QueueLL {
    public static void main(String[] args) {
        
    }
}
