/*
 * Reverse first K of a Queue
Difficulty: EasyAccuracy: 81.28%Submissions: 165K+Points: 2
Given an integer k and a queue of integers, we need to reverse the order of the first k elements of the queue, leaving the other elements in the same relative order.

Only following standard operations are allowed on queue.

enqueue(x) : Add an item x to rear of queue
dequeue() : Remove an item from front of queue
size() : Returns number of elements in queue.
front() : Finds front item.
Note: The above operations represent the general processings. In-built functions of the respective languages can be used to solve the problem.

"If the size of queue is smaller than the given k , then return the original queue."

Examples:

Input: q = [1, 2, 3, 4, 5], k = 3
Output: [3, 2, 1, 4, 5]
Explanation: After reversing the first 3 elements from the given queue the resultant queue will be 3 2 1 4 5
 */
import java.util.*;

class Solution {
    public java.util.Queue<Integer> reverseFirstK(java.util.Queue<Integer> q, int k) {
        if(k> q.size() || k< 0){
            return q;
        }

        Stack<Integer> stack = new Stack<>();

        // Step 1: Dequeue first k elements from the queue and push them onto the stack
        for(int i= 0; i<k; i++ ){
            stack.push(q.poll());

        }

        // Step 2: Pop elements from the stack and enqueue them back to the queue
        while(!stack.isEmpty()){
            q.add(stack.pop());

        }
        // Step 3: Move the remaining elements from the front to the back of the queue
        int size = q.size();    
        for(int i= 0; i< size - k; i++){
            q.add(q.poll());
        }
        return q;

    }

}
public class ReversefirstkElements {
    public static void main(String[] args) {
        Solution sol = new Solution();
        java.util.Queue<Integer> q = new java.util.LinkedList<>(java.util.Arrays.asList(1, 2, 3, 4, 5));
        int k = 3;
        java.util.Queue<Integer> result = sol.reverseFirstK(q, k);
        System.out.println(result); // Output: [3, 2, 1, 4, 5]

    }
    
}
