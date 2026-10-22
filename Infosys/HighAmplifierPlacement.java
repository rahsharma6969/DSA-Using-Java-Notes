

/*
# Problem Statement: Highway Amplifier Placement

There are `N` posts located along a highway. The positions of the posts
are given in a sorted integer array `posts[]`, where `posts[i]` 
represents the position of the `i`-th post.

Your task is to install amplifiers such that every post is covered.

There are two types of amplifiers available:

### 1. Normal Amplifier

- Can be installed at any position on the highway.
- If placed at position `x`, it covers all posts in the interval:

  \\[ [x-r,\ x+r] \\]
- There is an unlimited supply of normal amplifiers.

### 2. Super Amplifier

- Can also be installed at any position on the highway.
- If placed at position `x`, it covers all posts in the interval:

  \\[ [x-2r,\ x+2r] \\]

## Example 1

Input

```
5
1 3 5 7 10
2 1
```

Output

```
2
```

Explanation

- Place one Super Amplifier at position `5`.
- It covers the interval `[1, 9]`, covering posts `1, 3, 5, 7`.
- Another amplifier is needed to cover post `10`.

Note: The screenshots provided do not show the complete problem statement, 
including all input-format details and any remaining constraints. 
The statement above reconstructs the visible content; the exact meaning of the final 
input values `2 1` and whether the task is to minimize the number of amplifiers or account
for additional costs cannot be confirmed from the screenshots alone. */

import java.util.Arrays;

class Solutions {
 

    public int solve(int[] posts, int r, int i, int k) {
        int n = posts.length;

        // Base case: all posts are covered
        if (i >= n) {
            return 0;
        }

        // If this state is already calculated, reuse it
        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        // Choice 1: Normal Amplifier
        int j = i;
        int right = posts[i] + 2 * r;

        while (j < n && posts[j] <= right) {
            j++;
        }

        int normal = 1 + solve(posts, r, j, k);

        int result = normal;

        // Choice 2: Super Amplifier
        if (k > 0) {
            j = i;
            right = posts[i] + 4 * r;

            while (j < n && posts[j] <= right) {
                j++;
            }

            int superAmp = 1 + solve(posts, r, j, k - 1);

            result = Math.min(normal, superAmp);
        }

        // Save the minimum result
        return dp[i][k] = result;
    }

}

class Solution {
    public int minAmplifiers(int[] posts, int r) {
        int n = posts.length;
        int minCount = n + 1;

        // Try every possible post as the Super Amplifier position
        for (int i = 0; i < n; i++) {
            int count = 1;
            int left = posts[i] - 2 * r;
            int right = posts[i] + 2 * r;

            // Mark posts covered by the Super Amplifier
            boolean[] covered = new boolean[n];

            for (int j = 0; j < n; j++) {
                if (posts[j] >= left && posts[j] <= right) {
                    covered[j] = true;
                }
            }

            // Cover every remaining post with Normal Amplifiers
            for (int j = 0; j < n; j++) {
                if (!covered[j]) {
                    count++;

                    int normalRight = posts[j] + r;

                    // Cover as many subsequent posts as possible
                    for (int k = j; k < n; k++) {
                        if (posts[k] <= normalRight) {
                            covered[k] = true;
                        } else {
                            break;
                        }
                    }
                }
            }

            minCount = Math.min(minCount, count);
        }

        return minCount;
    }
}
public class HighAmplifierPlacement {
    public static void main(String[] args) {
        Solutions  sol = new Solution();
        int[] posts = {1, 3, 5, 7, 10};
        int r = 2;
        int k = 2;

        Arrays.sort(posts);

        int[][] dp = new int[posts.length][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int answer = sol.solve(posts, r, 0, k);

        System.out.println(answer);
    }
    
}
