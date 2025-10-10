
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

class LinkedList {
    Node head;
    Node tail;

    void addAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void addAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    void deleteAtHead() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }

    }

    void deleteAtTail() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = tail = null;
            return;
        }
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    void ReverseLinkedList() {
        if (head == null || head.next == null) {
            return; // Empty list or single node, no need to reverse
        }

        Node prevNode = head;
        Node currentNode = head.next;
        while (currentNode != null) {
            Node nextNode = currentNode.next;

            currentNode.next = prevNode;
            // update
            prevNode = currentNode;
            currentNode = nextNode;

        }

        head.next = null;
        head = prevNode;

    }

    void deleteNthNodeFromEnd(int n) {

        // Find the length of the list
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // If n is greater than length, do nothing
        if (n > length || n <= 0) {
            System.out.println("Invalid n");
            return;
        }

        // If deleting the head node
        if (n == length) {
            head = head.next;
            if (head == null)
                tail = null;
            return;
        }

        // Find the (length-n)th node (node before the one to delete)
        Node prev = head;
        for (int i = 1; i < length - n; i++) {
            prev = prev.next;
        }

        // Delete the nth node from end
        prev.next = prev.next.next;

        // If deleted node was tail, update tail
        if (prev.next == null) {
            tail = prev;
        }

    }

}

public class LL {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        list.display();
        list.ReverseLinkedList();
        list.display();
        // Reversing the linked list

    }
}
