
public class PartitionSetMinimumDifference {
    public static int minimumSubsetSumDifference(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= target; s++) {
                dp[i][s] = dp[i - 1][s];
                if (s >= nums[i - 1]) {
                    dp[i][s] = dp[i][s] || dp[i - 1][s - nums[i - 1]];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int s = 0; s <= target; s++) {
            if (dp[n][s]) {
                minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * s));
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 11, 5};
        System.out.println("Minimum subset sum difference: " + minimumSubsetSumDifference(nums));
    }
}
