
/*1049. Last Stone Weight II
Medium
Topics
premium lock icon
Companies
Hint
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the smallest possible weight of the left stone. If there are no stones left, return 0.

 

Example 1:

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
we can combine 1 and 1 to get 0, so the array converts to [1], then that's the optimal value.
Example 2:

Input: stones = [31,26,33,21,40]
Output: 5
 */


class Solution {

    int solve(int idx , int[] stones, int target) {

        if(target == 0) return 0;
        if(idx == 0) {
            if(stones[idx] <= target) return stones[idx];
            else return 0;
        }

        int not_take = solve(idx - 1 , stones, target);
        int pick = 0;
        if(stones[idx] <= target) {
            pick = stones[idx] + solve(idx - 1, stones,target - stones[idx]);
        }

        return Math.max(not_take, pick);
    }

    int solve(int idx , int[] stones, int target, int[][] dp) {

        if(target == 0) return 0;
        if(idx == 0) {
            if(stones[idx] <= target) return stones[idx];
            else return 0;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int not_take = solve(idx - 1 , stones, target, dp);
        int pick = 0;
        if(stones[idx] <= target) {
            pick = stones[idx] + solve(idx - 1, stones,target - stones[idx], dp);
        }

        return dp[idx][target] = Math.max(not_take, pick);
    }
    
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int totalSum = 0;
        for(int num : stones) {
            totalSum += num;
        }
        int[][] dp = new int[n][totalSum + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int target = totalSum / 2;
        int subsetSum = solve(n - 1, stones , target, dp);
        return totalSum - 2 * subsetSum;
    }
}
public class LastStoneII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stones = {2,7,4,1,8,1};
        int result = solution.lastStoneWeightII(stones);
        System.out.println(result); // Output: 1
    }
}
