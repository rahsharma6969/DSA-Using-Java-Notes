// kadane Algorithm
import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
            if (currentSum < 0) {
                currentSum = 0;
            }                            
        }
        return maxSum;
    }
}


public class MaxSubArraySum {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result = solution.maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result);

    }
}
