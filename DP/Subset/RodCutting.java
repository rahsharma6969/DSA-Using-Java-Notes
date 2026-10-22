/*Rod cutting problem
Subscribe to TUF+

Hints
Company
Given a rod of length N inches and an array price[] where price[i] denotes the value of a piece of rod of length i inches (1-based indexing). Determine the maximum value obtainable by cutting up the rod and selling the pieces. Make any number of cuts, or none at all, and sell the resulting pieces.


Example 1

Input: price = [1, 6, 8, 9, 10, 19, 7, 20], N = 8

Output: 25

Explanation: Cut the rod into lengths of 2 and 6 for a total price of 6 + 19= 25.

Example 2

Input: price = [1, 5, 8, 9], N = 4

Output: 10

Explanation: Cut the rod into lengths of 2 and 2 for a total price of 5 + 5 = 10.

 */

class Solution{

    int solve(int idx , int[] price , int N) {
        if( idx == 0){
            return N * price[0];
        }


        int not_pick = solve(idx - 1, price , N);
        int pick = 0;
        if(idx + 1 <=N ) {
            pick = price[idx] + solve(idx , price , N - idx - 1);
        }

        return Math.max(not_pick , pick);
    }

    // using memoization
    int solve(int idx , int[] price , int N, int[][] dp) {
        if( idx == 0){
            return N * price[0];
        }

        if(dp[idx][N] != -1) return dp[idx][N];

        int not_pick = solve(idx - 1, price , N, dp);
        int pick = 0;
        if(idx + 1 <=N ) {
            pick = price[idx] + solve(idx , price , N - idx - 1, dp);
        }

        return dp[idx][N] = Math.max(not_pick , pick);
    }
    
    public int RodCutting(int price[], int n) {
        if(n == 0) return 0;

        int idx = price.length;

        int[][] dp = new int[idx][n + 1];
        for(int i = 0; i < idx; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return  solve(idx - 1  , price , n, dp);
    }
}


public class RodCutting {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] price = {1, 5, 8 , 9};
        int N = 4;
        int maxValue = solution.RodCutting(price, N);
        System.out.println("Maximum value obtainable: " + maxValue);
    }
}