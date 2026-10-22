/*
 
Ninja's training
Subscribe to TUF+

Hints
Company
A ninja has planned a n-day training schedule. Each day he has to perform one of three activities - running, stealth training, or fighting practice. The same activity cannot be done on two consecutive days and the ninja earns a specific number of merit points, based on the activity and the given day.



Given a n x 3-sized matrix, where matrix[i][0], matrix[i][1], and matrix[i][2], represent the merit points associated with running, stealth and fighting practice, on the (i+1)th day respectively. Return the maximum possible merit points that the ninja can earn.


Example 1

Input: matrix = [[10, 40, 70], [20, 50, 80], [30, 60, 90]]

Output: 210

Explanation:

Day 1: fighting practice = 70

Day 2: stealth training = 50

Day 3: fighting practice = 90

Total = 70 + 50 + 90 = 210

This gives the optimal points.

Example 2

Input: matrix = [[70, 40, 10], [180, 20, 5], [200, 60, 30]]

Output: 290

Explanation:

Day 1: running = 70

Day 2: stealth training = 20

Day 3: running = 200

Total = 70 + 20 + 200 = 290

This gives the optimal points.
*/
class Solution {
    private int dfs(int day, int lastActivity, int[][] mat, int[][] memo) {
        if (day == 0) {
            int best = 0;
            for (int activity = 0; activity < 3; activity++) {
                if (activity != lastActivity) {
                    best = Math.max(best, mat[0][activity]);
                }
                
            }
            return best;
        }

        if (memo[day][lastActivity] != -1) {
            return memo[day][lastActivity];
        }

        int best = 0;
        for (int activity = 0; activity < 3; activity++) {
            if (activity == lastActivity) {
                continue;
            }
            best = Math.max(best, mat[day][activity] + dfs(day - 1, activity, mat, memo));
        }

        memo[day][lastActivity] = best;
        return best;
    }

    public int ninjaTraining(int matrix[][]) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }

        int[][] memo = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                memo[i][j] = -1;
            }
        }

        return dfs(n - 1, 3, matrix, memo);
    }
}

public class NInjaTraining {
    public static void main(String[] args) {
        int[][] mat = {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}
        };

        Solution solution = new Solution();
        System.out.println(solution.maximumPoints(mat)); // expected 210
    }
}
