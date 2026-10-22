/*
485. Max Consecutive Ones
Easy
Topics
premium lock icon
Companies
Hint
Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2


*/



class Solution {
    // Approach 1: Brute Force
    // time complexity: O(n)
    // space complexity: O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount =0;
        int start = 0;

        for(int end =0; end < nums.length; end++){
            if(nums[end] != 0){
                maxCount = Math.max(maxCount, end - start + 1);
            } else {
                start = end + 1;
            }
        }
        return maxCount;
    }

    // Approach 2: Sliding Window
    // time complexity: O(n)
    // space complexity: O(1)
    public int findMaxConsecutiveOnes2(int[] nums) {
        int maxcount = 0;
        int l = 0;

        for(int r = 0; r<nums.length; r++) {

            while(nums[r] == 0 && l <= r) {
                l = r + 1;
            }

        maxcount = Math.max(maxcount , r- l + 1);
      }
      return maxcount;
    }
}
// key difference between the two approaches is that the 
// first approach uses a single loop to count consecutive 1's and resets the count when it encounters a 0,
//  while the second approach uses a sliding window technique to maintain a count of consecutive 1's 
// and updates the maximum count accordingly. 
// Both approaches have the same time complexity of O(n) and space complexity of O(1).

public class MaxConsectiveOnes {
    public static void main(String[] args) {
        
    }
    
}
