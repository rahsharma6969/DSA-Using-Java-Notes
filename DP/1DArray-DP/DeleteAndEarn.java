/*
740. Delete and Earn
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

 

Example 1:

Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.
Example 2:

Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points. */

import java.util.*;
class Solution {

    public int deleteAndEarn(int[] nums) {

        // Find maximum value
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        // points[i] = total points earned from taking number i
        int[] points = new int[max + 1];

        for (int num : nums) {
            points[num] += num;
        }

        // dp[i] = maximum points we can earn from 0...i
        int[] dp = new int[max + 1];

        Arrays.fill(dp, -1);

        return solve(max, points, dp);
    }

    private int solve(int i, int[] points, int[] dp) {

        // Base case
        if (i < 0) {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        // Take i
        int take = points[i] + solve(i - 2, points, dp);

        // Don't take i
        int notTake = solve(i - 1, points, dp);

        return dp[i] = Math.max(take, notTake);
    }
}

public class DeleteAndEarn {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.deleteAndEarn(new int[]{3,4,2})); // 6
        System.out.println(s.deleteAndEarn(new int[]{2,2,3,3,3,4})); // 9
    }
}
