// constant sliding window approach to find maximum average of subarrays of size k

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
        
        int windowSum = 0;

        // Step 1: sum of first k elements
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Step 2: slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i];        // add new element
            windowSum -= nums[i - k];    // remove old element
            maxSum = Math.max(maxSum, windowSum);
        }

        // Step 3: return average
        return (double) maxSum / k;
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
