
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head = null;
    Node tail = null;

   void insertatHead(int data) {
    if(head == null) {
        head = tail = new Node(data);
        return;
    }
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
   }

   void insertatTail(int data) {
    if(head == null) {
        head = tail = new Node(data);
        return;
    }

    Node newNode = new Node(data);
    tail.next = newNode; 
    tail = newNode;
   }

   int removeAtHead() {
    if(head == null) return -1;
    int val = head.data;
    head = head.next;
    return val;
   }

   int removeAtTail() {
    if(head == null) return -1;
    if(head == tail) {
        int val = head.data;
        head = tail = null;
        return val;
    }
    Node curr = head;
    while(curr.next != tail) {
        curr = curr.next;
    }
    curr.next = null;
    tail = curr;
    return tail.data;
   }

    void display() {
     Node curr = head;
     while(curr != null) {
          System.out.print(curr.data + " ");
          curr = curr.next;
     }
     System.out.println();
    }
}

public class LL {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
       
        // Reversing the linked list

    }
}
