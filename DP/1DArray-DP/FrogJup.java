/*
Problem statement
There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to 
reach the 'Nth' stair. 'HEIGHT[i]' 
is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, 
the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ).
 If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair.
 Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

For Example
If the given ‘HEIGHT’ array is [10,20,30,10], 
the answer 20 as the frog can jump from 1st stair 
to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair 
to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20. 

here  n is the length of the given array. n = heights.length  
*/


class Solution {
    public static int helper(int idx, int heights[]) {
        if(idx <0) return 0;
        if(idx==0) return 0;
        if(idx == 1) return Math.abs(heights[1] - heights[0]);

        int jumpOne = helper( idx -1 , heights) + Math.abs(heights[idx] - heights[idx-1]);
        int jumpTwo = helper( idx -2 , heights) + Math.abs(heights[idx] - heights[idx-2]);

        return Math.min(jumpOne, jumpTwo);
       
     }
     // plan recursion
     public static int frogJump(int n, int heights[]) {
       int idx = n - 1;
       return helper(idx, heights);
      
    }

    // using memoization
    public static int frogJumpMemo(int n, int heights[]) {
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        int idx = n - 1;
        return frogJumpMemo(idx, heights, dp);
    }

    private static int frogJumpMemo(int idx, int heights[], int[] dp) {
        if(idx <0) return 0;
        if(idx==0) return 0;
        if(idx == 1) return Math.abs(heights[1] - heights[0]);
        if(dp[idx] != -1) return dp[idx];

        int jumpOne = frogJumpMemo( idx -1 , heights, dp) + Math.abs(heights[idx] - heights[idx-1]);
        int jumpTwo = frogJumpMemo( idx -2 , heights, dp) + Math.abs(heights[idx] - heights[idx-2]);

        return dp[idx] = Math.min(jumpOne, jumpTwo);
       
     }

     // using tabulation
     public static int frogJumpTab(int n, int heights[]) {
     int [] dp = new int[n + 1];
     dp[0] = 0;
     for(int i=1; i<n; i++) {
        int left = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
        int right = Integer.MAX_VALUE;
        if(i > 1) {
            right = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
        }
        dp[i] = Math.min(left, right);
     }
     return dp[n-1];
     }
}




public class FrogJup {
    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        Solution s = new Solution();
        System.out.println(s.frogJumpTab(stones.length, stones));
    }
}