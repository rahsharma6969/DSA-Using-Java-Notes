/*
Count partitions with given difference
Subscribe to TUF+

Hints
Company
Given an array arr of n integers and an integer diff, count the number of ways to partition the array into two subsets S1 and S2 such that:

∣S1−S2∣ = diff and S1 ≥ S2
Where |S1| and |S2| are sum of Subsets S1 and S2 respectively.


Return the result modulo 109 + 7.



Note: A partition means that the union of S1 and S2 is the original array, and no element is left out or used twice — every element of the array belongs to exactly one of the two subsets.


Example 1

Input: arr = [1, 1, 2, 3], diff = 1

Output: 3

Explanation: The subsets are [1, 2] and [1, 3], [1, 3] and [1, 2], [1, 1, 2] and [3].

Example 2

Input: arr = [1, 2, 3, 4], diff = 2

Output: 2

Explanation: The subsets are [1, 3] and [2, 4], [1, 2, 3] and [4]. */


class Solution {
    int solver(int idx, int[] arr, int target, Integer[][] dp) {
        if (idx == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || arr[0] == target) return 1;
            return 0;
        }

        if (dp[idx][target] != null) {
            return dp[idx][target];
        }

        int notTaken = solver(idx - 1, arr, target, dp);
        int taken = 0;
        if (arr[idx] <= target) {
            taken = solver(idx - 1, arr, target - arr[idx], dp);
        }
        return dp[idx][target] = taken + notTaken;
    }

    int perfectSum(int[] arr, int K) {
        int n = arr.length;
        Integer[][] dp = new Integer[n][K + 1];
        return solver(n - 1, arr, K, dp);
    }

    public int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        for (int x : arr) totalSum += x;

        // target must be non-negative and (totalSum + diff) must be even
        if (diff > totalSum || (totalSum + diff) % 2 != 0) return 0;

        int target = (totalSum + diff) / 2;
        return perfectSum(arr, target);
    }
}
