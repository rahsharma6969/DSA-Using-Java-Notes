/*
930. Binary Subarrays With Sum
Medium
Topics
premium lock icon
Companies
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
*/

import java.util.*;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);  // Initialize with 0 sum appearing once
        
        for(int num : nums) {
            sum += num;
            
            // If (sum - goal) exists, it means there's a subarray with sum = goal
            if(prefixCount.containsKey(sum - goal)) {
                count += prefixCount.get(sum - goal);
            }
            
            // Add current sum to the map
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
public class BinarySubArrayWithSum {
    public static void main(String[] args) {
        
    }
}
