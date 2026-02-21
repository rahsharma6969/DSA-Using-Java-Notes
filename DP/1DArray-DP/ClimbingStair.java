/*
climbing stairs problem
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
goal is to find the number of distinct ways to climb to the top of the staircase given n steps.
input :n = 3
output: 3
explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step 

*/
public class ClimbingStair {

    // time complexity: O(2^n)
    static int climbStairs(int n){
        // base case: if n is 0 or 1, there is only one way to climb the stairs
        if(n == 0 || n == 1) return 1;

        // recursive call: the number of ways to climb n stairs is the sum of the ways to climb n-1 and n-2 stairs
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // dp using memoization
    static int climbStairsMemo(int n, int[] memo){
        // base case: if n is 0 or 1, there is only one way to climb the stairs
        if(n == 0 || n == 1) return 1;

        // check if the value is already computed
        if(memo[n] != -1) return memo[n];

        // recursive call and store the result in memo
        memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        return memo[n];
    }
     public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
        int[] memo = new int[n + 1];
        for(int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        System.out.println(climbStairsMemo(n, memo));
     }   
}
