
// kadane Algorithm
/*
 * 
Code
Testcase
Testcase
Test Result
53. Maximum Subarray
Medium
Topics
premium lock icon
Companies
Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
*/
import java.util.*;

public class MaxSubArraySum {
    static int maxSubArray(int[] nums) {
       int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length ; i++){
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            if(currSum<0){
                currSum = 0;
            }
        }
        return maxSum;

        
    }

    public static void main(String[] args) {

        int[] nums = { -2 };
        int result = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result);

    }
}
