/*
## Problem Statement: Find the Beauty of the Subarray

Given an integer array `nums` containing `n` integers, find the beauty of every subarray of size `k`.

The beauty of a subarray is defined as:

- The `x`-th smallest integer in the subarray, if it is negative.
- Otherwise, the beauty is `0` if there are fewer than `x` negative integers in the subarray.

Return an integer array of size `n - k + 1`, where each element represents the beauty of the corresponding subarray in the order they appear.

A subarray is a contiguous, non-empty sequence of elements within an array.

### Input

- An integer array `nums`.
- An integer `k` representing the size of each subarray.
- An integer `x`.

### Example 1

Input:

```
nums = [1, -1, -3, -2, 3]
k = 3
x = 2
```

Explanation:

Subarrays of size `3`:

1. `[1, -1, -3]`
   - Sorted: `[-3, -1, 1]`
   - 2nd smallest: `-1`
   - Beauty: `-1`
2. `[-1, -3, -2]`
   - Sorted: `[-3, -2, -1]`
   - 2nd smallest: `-2`
   - Beauty: `-2`
3. `[-3, -2, 3]`
   - Sorted: `[-3, -2, 3]`
   - 2nd smallest: `-2`
   - Beauty: `-2`

Output:

```
[-1, -2, -2]
```

### Constraints

- \\(1 \le n \le 10^5\\)
- \\(1 \le k \le n\\)
- \\(1 \le x \le k\\)
- \\(-50 \le nums[i] \le 50\\) */

import java.util.*;

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int[] temp = Arrays.copyOfRange(nums, i, i + k);
            Arrays.sort(temp);

            if (temp[x - 1] < 0) {
                ans[i] = temp[x - 1];
            } else {
                ans[i] = 0;
            }
        }

        return ans;
    }
}
public class XthSmallestElement {
    public static void main(String[] args) {
        Soltion  sol = new Soltion();
        
    }
    
}
