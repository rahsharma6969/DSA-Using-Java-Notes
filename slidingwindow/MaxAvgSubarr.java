// constant sliding window approach to find maximum average of subarrays of size k
/*
643. Maximum Average Subarray I
Solved
Easy
Topics
premium lock icon
Companies
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

*/

class Solution {
    // brute force approach to find maximum average of subarrays of size k
    // time complexity: O(n*k)
    // space complexity: O(1)
    public double findMaxAverage(int[] nums, int k) {

        double maxAvg = -Double.MAX_VALUE;

        // Loop over all possible subarrays of size k
        for (int i = 0; i <= nums.length - k; i++) {

            int sum = 0;

            // Calculate sum of current subarray
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }

            double avg = (double) sum / k;
            maxAvg = Math.max(maxAvg, avg);
        }

        return maxAvg;
    }

    // optimize approach using sliding window
    // time complexity: O(n)
    // space complexity: O(1)

    public double findMaxAverageOptimized(int[] nums, int k) {
        int windowSum =0 ;

       for(int i=0;i<k;i++){
        windowSum += nums[i];
       }
       double maxSum = windowSum;

       for(int right=k; right<nums.length; right++){
        windowSum += nums[right];
        windowSum -= nums[right - k];

        maxSum = Math.max(windowSum , maxSum);
       }
       double maxAvg = maxSum/k;
       return maxAvg;

    
       
    }
}

public class MaxAvgSubarr {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double result = sol.findMaxAverage(nums, k);
        System.out.println("Maximum average of subarrays of size " + k + " is: " + result);
    }
}
