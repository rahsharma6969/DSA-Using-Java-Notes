// 377. Combination Sum IV
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

// The test cases are generated so that the answer can fit in a 32-bit integer.

 

// Example 1:
 
// Input: nums = [1,2,3], target = 4
// Output: 7
// Explanation:
// The possible combination ways are:
// (1, 1, 1, 1)
// (1, 1, 2)
// (1, 2, 1)
// (1, 3)
// (2, 1, 1)
// (2, 2)
// (3, 1)
// Note that different sequences are counted as different combinations.
// Example 2:

// Input: nums = [9], target = 3
// Output: 0
 

class Solution {

    int solve(int[] nums, int target) {

        if (target == 0) {
            return 1;
        }

        int ways = 0;

        for (int num : nums) {

            if (num <= target) {
                ways += solve(nums, target - num);
            }
        }

        return ways;
    }

    public int combinationSum4(int[] nums, int target) {
        return solve(nums, target);
    }
}



class Solution1 {

    int solve(int[] nums, int target, int[] dp) {

        // Base case
        if (target == 0) {
            return 1;
        }

        // Already calculated
        if (dp[target] != -1) {
            return dp[target];
        }

        int ways = 0;

        // Try every number as the next choice
        for (int num : nums) {

            if (num <= target) {
                ways += solve(nums, target - num, dp);
            }
        }

        return dp[target] = ways;
    }

    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];

        Arrays.fill(dp, -1);

        return solve(nums, target, dp);
    }
}
public class CombinationSumIV {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println(s.combinationSum4(nums, target));

    }
}
