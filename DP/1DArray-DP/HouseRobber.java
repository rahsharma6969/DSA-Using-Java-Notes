

class Solutions {

    public int maxCost(int[] nums, int idx) {

        if (idx == 0) return nums[0];
        if (idx == 1) return Math.max(nums[0], nums[1]);

        return Math.max(
                nums[idx] + maxCost(nums, idx - 2), // take
                maxCost(nums, idx - 1)              // not take
        );
    }

    public int rob(int[] nums) {

        int n = nums.length; // last index = n - 1
        if (n == 1) return nums[0];

        return maxCost(nums, n - 1);
    }

    // using memoization
    public int maxCostMemo(int[] nums, int idx, int[] dp) {
        if (idx == 0) return nums[0];
        if (idx == 1) return Math.max(nums[0], nums[1]);

        if (dp[idx] != -1) return dp[idx];

        dp[idx] = Math.max(
                nums[idx] + maxCostMemo(nums, idx - 2, dp), // take
                maxCostMemo(nums, idx - 1, dp)              // not take
        );
        return dp[idx];
    }

    public int robMemo(int[] nums) {
        int n = nums.length; // last index = n - 1
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return maxCostMemo(nums, n - 1, dp);
    }

    public int robTab(int[] nums) {
        int n = nums.length; // last index = n - 1
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2] , dp[i-1] );
        }
        return dp[n - 1];
    }
}

public class HouseRobber {
    public static void main(String[] args) {
        
    }
}
