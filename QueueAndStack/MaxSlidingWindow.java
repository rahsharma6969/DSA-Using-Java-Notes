/*
239. Sliding Window Maximum
Solved
Hard
Topics
premium lock icon
Companies
Hint
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
 */
import java.util.Deque;
import java.util.LinkedList;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < nums.length; i++){
            // remove indices that are out of the current window
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }

            // remove indices whose corresponding values are less than nums[i]
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }

            // add current index to the deque
            deque.offer(i);

            // if we've hit the size k, add the maximum to the result
            if(i >= k - 1){
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }
}


public class MaxSlidingWindow {
    public static void main(String[] args) {
        
    }
}
