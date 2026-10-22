/*
You are given an array `A` containing `N` integers and an integer `K`.

Your task is to divide the array into exactly K non-empty contiguous subarrays such that the sum of their dominance scores is maximized.

### What is a dominance score?

The dominance score of a subarray is the maximum frequency of any element in that subarray.

For example:

`A = [2, 3, 2, 4, 2]`

- Frequency of `2` = 3
- Frequency of `3` = 1
- Frequency of `4` = 1

Therefore, the dominance score of this subarray is 3.

### What is the partition score?

The partition score is the sum of the dominance scores of all `K` subarrays.

Your goal: Find the maximum possible partition score by splitting the array into exactly `K` non-empty contiguous subarrays.

### Example

Suppose:

```
A = [1, 2, 2, 3, 1]
K = 2
```

One possible partition is:

- Subarray 1: `[1, 2, 2]` → dominance score = 2
- Subarray 2: `[3, 1]` → dominance score = 1

Total score = `2 + 1 = 3`.

Another partition is:

- Subarray 1: `[1]` → dominance score = 1
- Subarray 2: `[2, 2, 3, 1]` → dominance score = 2

Total score = `1 + 2 = 3`.

We need to find the maximum score among all valid partitions.

The key constraint is that the subarrays must be contiguous, non-empty, and exactly K in number.
 */

import java.util.*;

class Solution {
    public int maxScore(int[] A, int K) {
        int N = A.length;
        int NEG = -1_000_000_000;

        int[][] dp = new int[K + 1][N + 1];

        for (int[] row : dp) {
            Arrays.fill(row, NEG);
        }

        dp[0][0] = 0;

        for (int k = 1; k <= K; k++) {
            for (int i = k; i <= N; i++) {

                HashMap<Integer, Integer> freq = new HashMap<>();
                int maxFreq = 0;

                for (int j = i - 1; j >= k - 1; j--) {
                    int count = freq.getOrDefault(A[j], 0) + 1;
                    freq.put(A[j], count);

                    maxFreq = Math.max(maxFreq, count);

                    if (dp[k - 1][j] != NEG) {
                        dp[k][i] = Math.max(
                            dp[k][i],
                            dp[k - 1][j] + maxFreq
                        );
                    }
                }
            }
        }

        return dp[K][N];
    }
}
public class DominanceScore {
    
}
