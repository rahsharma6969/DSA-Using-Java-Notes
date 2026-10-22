/*
Problem Statement: Andy's Vacation

Andy wants to go on a vacation to de-stress himself. He can take only one
continuous vacation during the next N days, where the days are numbered from
1 to N.

Andy already has M obligations scheduled on specific days. The i-th obligation
is on day D[i]. To extend his vacation, Andy is allowed to cancel at most K
obligations.

Determine the maximum number of consecutive vacation days Andy can take after
canceling at most K obligations.

Input Format

- The first line contains three integers N, M, and K:
  - N is the total number of days.
  - M is the total number of obligations.
  - K is the maximum number of obligations Andy can cancel.
- The second line contains M integers, where D[i] is the day on which the
  i-th obligation is scheduled. If M is 0, the second line may be empty.

Output Format

Print one integer: the maximum number of consecutive vacation days Andy can
take after canceling at most K obligations.

Constraints

- 0 <= M <= 2 * 10^5
- 0 <= K <= M
- 1 <= D[i] <= N
- All obligation days are distinct.

Sample Input

20 5 2
3 8 12 15 18

Sample Output

11
*/

import java.util.Arrays;

class Solution {
    public int maxVacation(int N, int M, int K, int[] D) {
        int[] obligations = Arrays.copyOf(D, M);
        Arrays.sort(obligations);

        if (M == 0) {
            return N;
        }

        int maxDays = 0;
        int right = 0;
        for (int left = 0; left <= M; left++) {
            right = Math.max(right, left);
            while (right < M && right - left < K) {
                right++;
            }

            int start = left == 0 ? 1 : obligations[left - 1] + 1;
            int end = right == M ? N : obligations[right] - 1;
            maxDays = Math.max(maxDays, end - start + 1);
      }

        return maxDays;
    }
}

public class andyvacation {
    
}
