/*
This is a variation of the Two City Scheduling problem.
Let's understand the logic using your sample input, step by step.

## 1. Understand the problem

There are \\(2N\\) employees, and exactly \\(N\\) must go to each city.

For every employee \\(i\\):

- City A: Cost = \\(A[i]\\)
- City B: Cost = \\(\min(A[i], B[i]) + B[i]\\)

We need to minimize the total cost while sending exactly \\(N\\) employees to each city.

## 2. Dry run with the sample input

Input:

```
N = 2
A = [10, 30, 50, 20]
B = [20, 10, 40, 30]
```

There are \\(2N = 4\\) employees, so 2 must go to City A and 2 to City B.

First, calculate the cost of sending each employee to either city.

| Employee | City A cost | City B cost: min(A[i], B[i]) + B[i] |
| -------- | ----------- | ----------------------------------- |
| 1        | 10          | min(10, 20) + 20 = 30               |
| 2        | 30          | min(30, 10) + 10 = 20               |
| 3        | 50          | min(50, 40) + 40 = 80               |
| 4        | 20          | min(20, 30) + 30 = 50               |

Now we have:

| Employee | City A | City B |
| -------- | ------ | ------ |
| 1        | 10     | 30     |
| 2        | 30     | 20     |
| 3        | 50     | 80     |
| 4        | 20     | 50     |

## 3. Find the minimum total cost

We need to choose exactly two employees for City A and the remaining two for City B.

One optimal assignment is:

- Employee 1 → City A: cost \\(10\\)
- Employee 4 → City A: cost \\(20\\)
- Employee 2 → City B: cost \\(20\\)
- Employee 3 → City B: cost \\(80\\)

Total:

\\[ 10+20+20+80=130 \\]

However, this is not the sample output of 120,
so let's check a better assignment.

Try:

- Employee 1 → City A: \\(10\\)
- Employee 3 → City A: \\(50\\)
- Employee 2 → City B: \\(20\\)
- Employee 4 → City B: \\(50\\)

Total:

\\[ 10+50+20+50=\boxed{130} \\]

Both give 130, not 120. That indicates a possible inconsistency between the displayed
formula and the sample output.

Important: Based on the formula shown in your screenshot,
the minimum is actually 120 if the intended City B cost is \\(B[i]\\) alone 
for the selected employees, rather than \\(\min(A[i],B[i])+B[i]\\).
Under that interpretation, the optimal assignment is:

- Employees 1 and 4 → City A: \\(10+20=30\\)
- Employees 2 and 3 → City B: \\(10+40=50\\)

Total \\(=80\\), which still doesn't match 120.

So before we implement the solution, we need to confirm the exact City B formula from the original question.
The formula in the image appears to be \\(\min(A[i], B[i]) + B[i]\\),
but the sample output of 120 does not match it. */


import java.util.Arrays;

class Solution {
    public long minCost(int[] A, int[] B) {
        if (A == null || B == null || A.length != B.length || A.length % 2 != 0) {
            throw new IllegalArgumentException("A and B must have equal, even lengths");
        }

        int n = A.length / 2;
        long total = 0;
        long[] savings = new long[A.length];

        for (int i = 0; i < A.length; i++) {
            long cityBCost = (long) Math.min(A[i], B[i]) + B[i];
            total += cityBCost;
            savings[i] = cityBCost - A[i];
        }

        Arrays.sort(savings);
        for (int i = savings.length - n; i < savings.length; i++) {
            total -= savings[i];
        }

        return total;
    }
}

public class CityAssigning {
   public static void main(String[] args) {
    
   } 
}
