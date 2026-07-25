
/* Fibonacci Number 
0 1 1 2 3 5 8 13 ...*/

import java.util.Arrays;
class Solution {
    public int Memo(int n, int[] memo) {
        if( n == 0) return 0;
        if( n == 1) return 1;

        if(memo[n] != -1) return memo[n];

        return memo[n] = Memo(n - 1, memo) + Memo(n - 2, memo);
    }

    public int fib(int n) {
       int[] memo = new int[n+1];
       Arrays.fill(memo, -1);
       return Memo(n, memo);    
    }
}
public class Fibonacci {
    // time complexity: O(2^n) - Exponential because of the repeated calculations of the same Fibonacci numbers.
    static int fibonacci(int n){

        if(n == 0) return 0; 
        if(n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
     // tc is O(n) and sc is O(n) due to recursion stack
    static int fibonacciMemo(int n, int[] memo) {
        if( n == 0) return 0;
        if( n == 1) return 1;

        if(memo[n] != -1) return memo[n];

        return memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
    }
     // time complexity: O(n) and space complexity: O(n) due to dp array
    static int fibonacciTb(int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2 ;i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
       

  
    

   
    public static void main(String[] args) {
        int n = 5; // Change this value to compute Fibonacci for different n
        int[] memo = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}
