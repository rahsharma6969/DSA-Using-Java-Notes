/*
2035. Partition Array Into Two Arrays to Minimize Sum Difference
Hard
Topics
premium lock icon
Companies
Hint
You are given an integer array nums of 2 * n integers. 
You need to partition nums into two arrays of length n to minimize
the absolute difference of the sums of the arrays. To partition nums,
put each element of nums into one of the two arrays.

Return the minimum possible absolute difference.

 

Example 1:

example-1
Input: nums = [3,9,7,3]
Output: 2
Explanation: One optimal partition is: [3,9] and [7,3].
The absolute difference between
 the sums of the arrays is abs((3 + 9) - (7 + 3)) = 2.
 
Example 2:

Input: nums = [-36,36]
Output: 72
Explanation: One optimal partition is: [-36] and [36].
The absolute difference between the sums of the arrays is
abs((-36) - (36)) = 72.


 example 3:
 Input: nums = [2,-1,0,4,-2,-9]
Output: 0
Explanation: One optimal partition is: [2,4,-9] and [-1,0,-2].
The absolute difference between the sums of the arrays is 
abs((2 + 4 + -9) - (-1 + 0 + -2)) = 0.
*/


//Approach :
// Use tabulation to compute all reachable sums for exactly n numbers,
// then choose the one minimizing the absolute difference.

class Solution {
    
    public int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // dp[target] = true if 'target' sum is achievable using some subset
        boolean[] dp = new boolean[totalSum + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            boolean[] next = new boolean[totalSum + 1];
            next[0] = true;
            for (int target = 1; target <= totalSum; target++) {
                boolean notTake = dp[target];
                boolean take = (arr[i] <= target) && dp[target - arr[i]];
                next[target] = take || notTake;
            }
            dp = next;
        }

        // Find the minimum |totalSum - 2*s1| over all achievable s1 in [0, totalSum/2]
        int minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= totalSum / 2; s1++) {
            if (dp[s1]) {
                int s2 = totalSum - s1;
                minDiff = Math.min(minDiff, Math.abs(s2 - s1));
            }
        }
        return minDiff;
    }

}