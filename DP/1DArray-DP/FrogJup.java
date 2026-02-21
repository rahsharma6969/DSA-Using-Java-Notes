/*
Problem statement
There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

For Example
If the given ‘HEIGHT’ array is [10,20,30,10], 
the answer 20 as the frog can jump from 1st stair 
to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair 
to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20. */


class Solution {
    // using plain recursion
    static int minEnergy(int n, int[] height){
        if(n == 0) return 0; // base case: if the frog is on the first stair, no energy is lost
        if (n == 1) return 0; // base case: if the frog is on the first stair, no energy is lost


        // recursive case: the frog can jump from (n-1)th stair or (n-2)th stair
        int leftJump = minEnergy( n-1, height) + Math.abs( height[n - 1] - height[n - 2] ); // energy lost if the frog jumps from (n-1)th stair
        int rightJump = Integer.MAX_VALUE;
        if(n > 2) {
            rightJump = minEnergy( n-2, height) + Math.abs( height[n - 1] - height[n - 3] ); // energy lost if the frog jumps from (n-2)th stair
        }
        
        return Math.min(leftJump, rightJump);
    }

    // using dp with memoization
    static int minEnergyMemo(int index, int[] height, int[] dp) {

        // Base case: starting stair
        if (index == 0)
            return 0;

        // If already computed
        if (dp[index] != -1)
            return dp[index];

        // Jump from previous stair (index-1)
        int left = minEnergyMemo(index - 1, height, dp) 
                   + Math.abs(height[index] - height[index - 1]);

        int right = Integer.MAX_VALUE;

        // Jump from two stairs behind (index-2)
        if (index > 1) {
            right = minEnergyMemo(index - 2, height, dp) 
                    + Math.abs(height[index] - height[index - 2]);
        }

        // Store and return minimum
        dp[index] = Math.min(left, right);
        return dp[index];
    }
}
public class FrogJup {
    public static void main(String[] args) {
        int[] height = {10, 20, 30, 10};
        int n = height.length;
        System.out.println(Solution.minEnergy(n, height));
        int[] memo = new int[n + 1];
        for(int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        System.out.println(Solution.minEnergyMemo(n, height, memo));
    }
    
}
