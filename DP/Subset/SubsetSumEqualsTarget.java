/* 
Subset Sum Problem
Difficulty: MediumAccuracy: 32.0% 
Submissions: 439K+
Points: 4
Given an array of positive integers arr[] and a value sum, 
determine if there is a subset of arr[] with sum equal to given sum. 

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true 
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.
*/
import java.util.Arrays;
class Solution {
    // using recursion
//     static boolean solve(int idx , int[] arr , int target){
//         if(target == 0) return true;
//         if(idx == 0) {
//             if(arr[idx] != target) return false;
//             else return true;
//         }
//         boolean nottaken = solve(idx-1, arr, target);
//         boolean taken = false;
//         if(arr[idx] <= target){
//             taken = solve(idx-1, arr, target-arr[idx]);
//         }
//         if(taken) return true;
//         else return nottaken;

//     }

//     static Boolean isSubsetSum(int arr[], int sum) {
//        int n = arr.length;
//        return solve(n-1, arr, sum); 
//     }
// }

    // using memoization
    // time complexity : O(N*sum) where N is the size of the array and sum is the target sum
    // space complexity : O(N*sum) for the dp array + O(N) for
    static boolean solveMemo(int idx , int[] arr , int target, Boolean[][] dp){
        if(target == 0) return true;
        if(idx == 0) {
            if(arr[idx] != target) return false;
            else return true;
        }
        if(dp[idx][target] != null) return dp[idx][target];
        boolean nottaken = solveMemo(idx-1, arr, target, dp);
        boolean taken = false;
        if(arr[idx] <= target){
            taken = solveMemo(idx-1, arr, target - arr[idx], dp);
        }
        return dp[idx][target] = taken || nottaken;

    }

    static Boolean isSubsetSum(int arr[], int sum) {
       int n = arr.length;
       Boolean[][] dp = new Boolean[n][sum+1];
       for(Boolean[] row : dp){
            Arrays.fill(row, null);
    }
       return solveMemo(n-1, arr, sum, dp); 
    }

    // using tabulation
    // time complexity : O(N*sum) where N is the size of the array and sum is the target sum
    // space complexity : O(N*sum) for the dp array
    static Boolean isSubsetSumTab(int arr[], int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= sum) dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++){
            for(int target = 1; target <= sum; target++){
                boolean nottaken = dp[i-1][target];
                boolean taken = false;
                if(arr[i] <= target){
                    taken = dp[i-1][target-arr[i]];
                }
                dp[i][target] = taken || nottaken;
            }
        }
        return dp[n-1][sum];
    }
}
public class SubsetSumEqualsTarget {
    
}
