/*
746. Min Cost Climbing Stairs
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given an integer array cost where cost[i] is the cost 
of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6. */
import java.util.Arrays;

class Solution {
    // using plain recursion
    public int minCost(int[] cost, int idx) {

    if (idx == 0) return cost[0];
    if (idx == 1) return cost[1];

    return cost[idx] + Math.min(
            minCost(cost, idx - 1), 
            minCost(cost, idx - 2) 
    );
}
public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    return Math.min(
            minCost(cost, n - 1), // we can start from either the last step or the second last step
            minCost(cost, n - 2)
    );
}

 /// using memoization
    public int minCostMemo(int[] cost, int idx, int[] dp) {

        if (idx == 0) return cost[0];
        if (idx == 1) return cost[1];

        if (dp[idx] != -1) return dp[idx];

        dp[idx] = cost[idx] + Math.min(
                minCostMemo(cost, idx - 1, dp),
                minCostMemo(cost, idx - 2, dp)
        );
        return dp[idx];
    }
    public int minCostClimbingStairsMemo(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(
                minCostMemo(cost, n - 1, dp),
                minCostMemo(cost, n - 2, dp)
        );
    }
}
public class MinCostClimbingStair {
    
}
/*
minCostClimbingStairs
                   /                     \
            minCost(idx=2)           minCost(idx=1)
            20 + min(?, ?)               └─ 15  ← base case
             /            \
      minCost(idx=1)   minCost(idx=0)
           └─ 15            └─ 10
           base case        base case
           
           */