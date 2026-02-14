/*209. Minimum Size Subarray Sum
Solved
Medium
Topics
premium lock icon
Companies
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */
class Solution{

    // using sliding window approach
    //time complexity: O(n)
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int right=0; right<n; right++){
            sum += nums[right];

            while(sum >= target){
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
      }
    }

    // brute force approach
    // time complexity: O(n^2)
    public int minSubArrayLenBrute(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                if(sum >= target){
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}


public class MinSizeSubArrSum {
    public static void main(String[] args) {
        
    }
}
