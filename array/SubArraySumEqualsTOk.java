/*
560. Subarray Sum Equals K

Medium
Topics

Companies
Hint
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 */

import java.util.HashMap;
import java.util.Map;
class Solutions {

    int subarraySum3(int[] nums, int k) {
    int count = 0;

    for (int i = 0; i < nums.length; i++) { // start index
        for (int j = i; j < nums.length; j++) { // end index
            int sum = 0;
            for (int p = i; p <= j; p++) { // sum from i to j
                sum += nums[p];
            }
            if (sum == k) {
                count++;
            }
        }
    }
    return count;
}


    // time complexity: O(n^2)
    int subarraySum(int[] nums, int k) {
   
     int count = 0;
     for(int i=0; i<nums.length;i++){
         int sum = 0;
        for(int j=i; j<nums.length; j++){
           
            sum += nums[j];
            if(sum == k){
                count++;
            }
        }
     }
        return count; 
       
    }

    // optimized approach using hashmap to store prefix sums
    // this method also reduce the duplicate calculation of sums
    // time complexity: O(n)
    // space complexity: O(n)
    int subarraySumOptimized(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with sum 0 occurring once
        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

public class SubArraySumEqualsTok {
    public static void main(String[] args) {
        Solutions sol = new Solutions();
        int[] nums = {1, 2, 3};
        int k = 3;
        int result = sol.subarraySum(nums, k);
        System.out.println("Number of subarrays: " + result);

       
    }
}
