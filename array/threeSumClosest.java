/*
16. 3Sum Closest
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums of length n and an integer target, find three integers at distinct indices in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).   */
import java.util.Arrays;
import java.util.*;
class Solution{
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2]; 
        for(int i=0; i< n ; i++){
            int left = i+1;
            int right = n -1;

            while( left < right){
                int sum  = nums[i] + nums[left] + nums[right];
                
                // Update closest if current sum is closer to target
                if(Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                
                // Move pointers based on comparison with target
                if(sum == target) {
                    return sum;  // Exact match found, can't get closer
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closest;
    }
}

public class threeSumClosest {
    public static void main(String[] args) {
        
    }
}
