/*
Here is the question as reconstructed from your two screenshots. The part between them (the cost formula) and the constraints and sample cases weren't visible, so I've marked what I filled in.

---

## Problem Statement

A staircase contains **N** steps numbered from **1** to **N**.

You start from step **1** and want to reach step **N**.

From any step, you may jump **only to the next Fibonacci step ahead**. That is, if you are currently on step `i`, you may move to:

- i + 1
- i + 2
- i + 3
- i + 5
- i + 8
- ...

where the jump length must be a Fibonacci number and the destination must not exceed N.

*[Not visible in your screenshots: the line giving the cost of a jump. From your first message, it is]*

The cost of a jump of length **k** is `A + B × k`

where:

- **A** = fixed cost per jump
- **B** = cost per step jumped
- **k** = jump length (a Fibonacci number)

Find the **minimum total cost** required to reach step **N**.

## Input Format

```
N A B
```

## Output Format

Print a single integer representing the minimum total cost.

---

## Not captured

- **Constraints**, such as the maximum value of N, A and B. These decide whether DP is fast enough or you need the greedy O(log N) method.
- **Sample input and output** and the explanation below them.

If you screenshot that part of the video, I can add it so you have the complete question and can test your code against the official sample.
 */

import java.util.*;

class Solution {
    // memoization approach
    static long[] memo;
    List<Integer> fib = new ArrayList<>();
    
    private long solve(int i, int N, long A, long B) {
    if (i == N) return 0;
    if (memo[i] != -1) return memo[i];                  // already computed
    long best = Long.MAX_VALUE;
    for (int k : fib) {
        if (i + k > N) break;
        best = Math.min(best, A + B * k + solve(i + k, N, A, B));
    }
    return memo[i] = best;
}
    public int minCost(int N, long A, long B) {
        
        int a = 1, b = 2;
        while (a <= N) { // calculate all fibonacci numbers up to N
            fib.add(a);
            int c = a + b;
            a = b;
            b = c;
        }
        memo = new long[N + 1];
        Arrays.fill(memo, -1);
        return (int) solve(1, N, A, B);
        
    }
}

public class FibonacciStairs {
    static List<Integer> fib = new ArrayList<>();

    static long solve(int i, int N, long A, long B) {
        if (i == N) return 0;
        long best = Long.MAX_VALUE;
        for (int k : fib) {
            if (i + k > N) break;                       // can't overshoot N
            best = Math.min(best, A + B * k + solve(i + k, N, A, B));
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long A = sc.nextLong(), B = sc.nextLong();
        buildFib(N);
        System.out.println(solve(1, N, A, B));
    }

    static void buildFib(int N) {
        int a = 1, b = 2;
        while (a <= N) { fib.add(a); int c = a + b; a = b; b = c; }
    }
}