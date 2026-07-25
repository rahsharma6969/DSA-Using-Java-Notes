/*
Check if there exists a subsequence with sum K
Subscribe to TUF+

Hints
Company
Given an array nums and an integer k. R﻿eturn true if there exist subsequences such that the sum of all elements in subsequences is equal to k else false.


Example 1

Input : nums = [1, 2, 3, 4, 5] , k = 8

Output : Yes

Explanation : The subsequences like [1, 2, 5] , [1, 3, 4] , [3, 5] sum up to 8.
 */
import java.util.*;

class Solution {

    public boolean helper(int[] nums , int index , int sum , int k) {
         if(sum == k) {
            return true;
         }
         if(index == nums.length) {
            return false;
         }

         return helper(nums , index+1 , sum+ nums[index] , k) || helper(nums , index+1 , sum , k);
    }
    public boolean checkSubsequenceSum(int[] nums, int k) {
         //your code goes here
         return helper(nums , 0 , 0, k);
    }
}

public class SubsequenceSum {
    
}
