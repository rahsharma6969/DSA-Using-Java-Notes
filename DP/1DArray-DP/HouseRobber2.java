

/*
213. House Robber II
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 */

import java.util.Arrays;


class Solution {
   



    // Solves House Robber I for the range [start...end]
    public int solver(int[] money, int idx, int start) {

        // Base cases
        if (idx < start) return 0;
        if (idx == start) return money[start];

        // Pick or Not Pick
        return Math.max(
                money[idx] + solver(money, idx - 2, start),
                solver(money, idx - 1, start)
        );
    }

    public int houseRobber(int[] money) {

        int n = money.length;

        // Edge case
        if (n == 1) return money[0];

        // Case 1: Exclude last house
        int case1 = solver(money, n - 2, 0);

        // Case 2: Exclude first house
        int case2 = solver(money, n - 1, 1);

        return Math.max(case1, case2);
    }


    // private int solve(int index, int[] nums, int start, int[] dp) {

    //     if(index < start) {
    //         return 0;
    //     }

    //     if(dp[index] != -1) {
    //         return dp[index];
    //     }

    //     int pick = nums[index] + solve(index - 2, nums, start, dp);
    //     int notPick = solve(index - 1, nums, start, dp);

    //     return dp[index] = Math.max(pick, notPick);
    // }

    // public int rob(int[] nums) {

    //     int n = nums.length;

    //     if(n == 1) {
    //         return nums[0];
    //     }

    //     // Case 1: houses [0 ... n-2]
    //     int[] dp1 = new int[n];
    //     Arrays.fill(dp1, -1);
    //     int case1 = solve(n - 2, nums, 0, dp1);

    //     // Case 2: houses [1 ... n-1]
    //     int[] dp2 = new int[n];
    //     Arrays.fill(dp2, -1);
    //     int case2 = solve(n - 1, nums, 1, dp2);

    //     return Math.max(case1, case2);
    // }
    // // using memoization

}


public class HouseRobber2 {
    public static void main(String[] args) {
        Solution sol = 
    }
}
