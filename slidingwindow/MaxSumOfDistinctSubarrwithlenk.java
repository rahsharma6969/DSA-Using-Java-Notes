/*
2461. Maximum Sum of Distinct Subarrays With Length K
Medium


You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
 */

import java.util.HashMap;
import java.util.Map;
class Solution{
    // sliding window + hashmap
    // time complexity: O(n)
    // space complexity: O(k)
    public long maximumSubarraySum(int[] nums, int k) {
        int maxSum = 0;
        int windowSum = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int n = nums.length;

        // Step 1: process first k elements
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        if (freqMap.size() == k) {
            maxSum = windowSum;
        }
        // Step 2: slide the window and update sums and frequencies from left to right
        for(int i=k; i<n;i++){
            windowSum += nums[i];
            windowSum -= nums[i - k];
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            freqMap.put(nums[i - k], freqMap.getOrDefault(nums[i - k], 0) - 1);
            if (freqMap.get(nums[i - k]) == 0) { // remove element with zero frequency from map because we need distinct elements
                freqMap.remove(nums[i - k]);
            }
            if (freqMap.size() == k && windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        return maxSum;
    }
}

public class MaxSumOfDistinctSubarrwithlenk {
    public static void main(String[] args) {
        
    }
}
