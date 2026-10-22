/*219. Contains Duplicate II
Solved
Easy
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, return true 
if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false */

import java.util.HashSet;
import java.util.Set;

class Solution{
    // brute force approach to check if array contains duplicates within k distance
    // time complexity: O(n^2)
    // space complexity: O(1)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
           for(int j=i+1;j<=i+k;j++){
            if(j<nums.length && nums[i] == nums[j] && Math.abs(i-j) <= k){
                return true;
            }
        }
    }
          return false;
    }

    // optimized approach using HashSet
    // time complexity: O(n)
    // space complexity: O(min(n,k))
    public boolean containsNearbyDuplicateOptimized(int[] nums, int k) {
                Set<Integer> seen = new HashSet<>();
                for (int i = 0; i < nums.length; i++) {
                        // If current value already in the set, we've seen a duplicate within k distance
                        if (seen.contains(nums[i])) {
                                return true;
                        }
                        seen.add(nums[i]);
                        // Keep the set size at most k (contains previous k elements)
                        if (seen.size() > k) {
                                seen.remove(nums[i - k]);
                        }
                }

                return false;
    }
}

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,3,1};
        int k = 3;
        boolean result = sol.containsNearbyDuplicate(nums, k);
        System.out.println("Contains nearby duplicate: " + result);
    }
}
