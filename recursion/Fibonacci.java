public class Fibonacci {

    static int fibonacci(int n){
        // base case: F(0) = 0, F(1) = 1
        if(n == 0 || n == 1) return n;

        // recursive call: F(n) = F(n-1) + F(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // dp using memoization
    static int fibonacciDP(int n, int[] memo){
        // base case: F(0) = 0, F(1) = 1
        if(n == 0 || n == 1) return n;

        // check if the value is already computed
        if(memo[n] != -1) return memo[n];

        // recursive call and store the result in memo
        memo[n] = fibonacciDP(n - 1, memo) + fibonacciDP(n - 2, memo);
        return memo[n];
    }

    // dp using tabulation
    static int fibonacciTabulation(int n){
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5; // Change this value to compute Fibonacci for different n
        int[] memo = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        System.out.println("Fibonacci of " + n + " is: " + fibonacciDP(n, memo));
    }
}
