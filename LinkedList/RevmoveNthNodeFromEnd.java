/*
19. Remove Nth Node From End of List
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
 */


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      int size = 0;
      ListNode curr = head;

      while(curr != null || curr.next != null) {
        curr = curr.next;
        size++;
      }
      size - n;
       
    }
}
public class RevmoveNthNodeFromEnd {
    
}
