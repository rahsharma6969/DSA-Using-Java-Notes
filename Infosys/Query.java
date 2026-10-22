/*
# Problem Statement: Data Center Cooling System

You manage a data center cooling system with `n` time intervals indexed from `0` to `n-1`.

Each interval has an initial heat load.

You are given:

- An integer `d` representing the minimum separation between selected cooling units.
- `q` operations.

Each operation is one of the following:

### 1. Update Operation

Format:

```
1 position value
```

Update the heat load at `position` to `value`.

### 2. Query Operation

Format:

```
2 l r k critical
```

Within the range `[l, r]`:

- Select at most `k` cooling units.
- Selected intervals must be at least `d` intervals apart.
- Intervals are greedily selected in descending order of heat load.
- If the heat load is greater than or equal to `critical`, the cooling unit enters turbo mode and contributes according to the problem's turbo-mode rule.
- Otherwise, the contribution is determined by the normal-mode rule.

For every query operation, compute the maximum total heat reduction.

Return the sum of the results of all query operations.

## Example

Input

```
n = 3
d = 1
heat = [5, 5, 5]
q = 1

Query:
2 0 2 3 0
```

Note: The provided statement does not specify the exact contribution rules
for turbo mode and normal mode, so those details remain undefined.

*/


import java.util.*;

class Solution {

    public long solve(int n, int d, int[] heat, int[][] queries) {
        long total = 0;

        for (int[] query : queries) {

            if (query[0] == 1) {
                // Update operation: 1 position value
                int position = query[1];
                int value = query[2];

                heat[position] = value;

            } else if (query[0] == 2) {
                // Query operation: 2 l r k critical
                int l = query[1];
                int r = query[2];
                int k = query[3];
                int critical = query[4];

                List<Integer> indices = new ArrayList<>();

                for (int i = l; i <= r; i++) {
                    indices.add(i);
                }

                // Sort by descending heat load
                indices.sort((a, b) -> {
                    if (heat[a] != heat[b]) {
                        return Integer.compare(heat[b], heat[a]);
                    }
                    return Integer.compare(a, b);
                });

                List<Integer> selected = new ArrayList<>();
                long reduction = 0;

                for (int idx : indices) {
                    if (selected.size() >= k) {
                        break;
                    }

                    boolean valid = true;

                    // Check minimum separation
                    for (int prev : selected) {
                        if (Math.abs(idx - prev) < d) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        selected.add(idx);

                        // Updated contribution logic
                        if (heat[idx] >= critical) {
                            reduction += 4L * heat[idx];
                        } else {
                            reduction += heat[idx];
                        }
                    }
                }

                total += reduction;
            }
        }

        return total;
    }
}

public class Query {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 3;
        int d = 1;
        int[] heat = {5, 5, 5};

        int[][] queries = {
            {2, 0, 2, 3, 0}
        };

        System.out.println(sol.solve(n, d, heat, queries));
    }
}