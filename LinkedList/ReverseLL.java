class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}



public class ReverseLL {

    ListNode reverse(ListNode head){

        if(head == null ) return null;
        if(head.next == null) return head;
        
        ListNode  prev = null;
        ListNode curr = head;

        while(curr.next != null){
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
       

    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

      
        
    
    }
}
