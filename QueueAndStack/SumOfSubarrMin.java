/*907. Sum of Subarray Minimums
Medium
Topics
premium lock icon
Companies
Given an array of integers arr, find the sum of min(b), 
where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
  */


import java.util.Stack;
import java.util.*;
class Solution {
    
    public void pse(int[] arr, int[] left) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
    }
    public void nse(int[] arr, int[] left, int[] right) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];   
        nse(arr, left, right);
        long ans = 0;
        for(int i = 0; i < n; i++) {
            long l = left[i] == -1 ? i + 1 : i - left[i];
            long r = right[i] == n ? n - i : right[i] - i;
            ans += (l * r * arr[i]) % 1000000007;
            ans %= 1000000007;
        }
        return (int)ans;
    }
}
public class SumOfSubarrMin {
    
}
