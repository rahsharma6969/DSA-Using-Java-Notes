/*Max Sum Subarray of size K
Difficulty: Easy 
Accuracy: 49.6% 
Submissions: 260K+
Points: 2
Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.

Note: A subarray is a contiguous part of any given array.

Examples:

Input: arr[] = [100, 200, 300, 400], k = 2
Output: 700
Explanation: arr2 + arr3 = 700, which is maximum.
 */
class Solution {
    // time complexity: O(n)
    // space complexity: O(1)
    public int maxSubarraySum(int[] arr, int k) {
     
        int sum = 0;
        // time complexity: O(k)
        for(int i=0; i<k ; i++){
            sum += arr[i];
        }
       int maxSum = sum;
        // time complexity: O(n-k)
        for(int right = k; right< arr.length;right++){
            sum += arr[right];
            sum -= arr[right - k];
            
            maxSum = Math.max(sum, maxSum);
            
        }
        // overall time complexity: O(k + n-k) = O(n)
        return maxSum;
    }
}
public class MaxSubarrOfSizek {
    
}
