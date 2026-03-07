/*
Geek is going for a training program for n days.
He can perform any of these activities: Running, Fighting,
and Learning Practice. Each activity has some point on each day. 
As Geek wants to improve all his skills, he can't do the same activity on two consecutive days.
Given a 2D matrix mat[][], where mat[i][0], mat[i][1], and mat[i][2]
represent the merit points for Running, Fighting, and Learning on the i-th day,
determine the maximum total merit points Geek can achieve .

Example:

Input:mat[][]= [[1, 2, 5],
               [3, 1, 1], 
               [3, 3, 3]]
Output: 11
Explanation: Geek will learn a new move and earn 5 point then on second day he will do running and earn 3 point and on third day he will do fighting and earn 3 points so, maximum merit point will be 11. */

class Solution {
    int calculate(int i, int j , int [][] mat, int last) {
        if(i < 0) return 0;

        int max = 0;
        for(int k = 0; k < 3; k++){
            if(k != last){
                int point = mat[i][k] + calculate(i-1, k, mat, k);
                max = Math.max(max, point);
            }
        }
        return max;
    }
    public int maximumPoints(int mat[][]) {
        if(mat.length == 0) return 0;
        // code here
        int m = mat.length;
        int n = mat[0].length;

        int max = 0;
        for(int i = 0; i < 3; i++){
            max = Math.max(max, calculate(m-1, i, mat, -1));
        }
        return max;
    }

    public static int ninjaTraining(int n, int[][] points) {

    int[][] dp = new int[n][4];

    // Base case (day 0)
    dp[0][0] = Math.max(points[0][1], points[0][2]);
    dp[0][1] = Math.max(points[0][0], points[0][2]);
    dp[0][2] = Math.max(points[0][0], points[0][1]);
    dp[0][3] = Math.max(points[0][0],
                Math.max(points[0][1], points[0][2]));

    for (int day = 1; day < n; day++) {
        for (int last = 0; last < 4; last++) {

            dp[day][last] = 0;

            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    int point = points[day][task] + dp[day - 1][task];
                    dp[day][last] = Math.max(dp[day][last], point);
                }
            }
        }
    }

    return dp[n - 1][3];
}
}
public class NInjaTraining {
    
}
