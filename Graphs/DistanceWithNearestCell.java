/*
Distance of nearest cell having 1
Difficulty: MediumAccuracy: 47.7%Submissions: 123K+Points: 4Average Time: 20m
Given a binary grid[][], where each cell contains either 0 or 1, find the distance of the nearest 1 for every cell in the grid.
The distance between two cells (i1, j1)  and (i2, j2) is calculated as |i1 - i2| + |j1 - j2|. 
You need to return a matrix of the same size, where each cell (i, j) contains the minimum distance from grid[i][j] to the nearest cell having value 1.

Note: It is guaranteed that there is at least one cell with value 1 in the grid.

Examples

Input: grid[][] = [[0, 1, 1, 0], 
                [1, 1, 0, 0], 
                [0, 0, 1, 1]]
Output: [[1, 0, 0, 1], 
        [0, 0, 1, 1], 
        [1, 1, 0, 0]]
Explanation: The grid is -

- 0's at (0,0), (0,3), (1,2), (1,3), (2,0) and (2,1) are at a distance of 1 from 1's at (0,1), (0,2), (0,2), (2,3), (1,0) and (1,1) respectively.

 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

class Pair {

    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
   // time complexity: O(m*n)
   // space complexity: O(m*n)
   // Approach: Multi Source BFS
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m][n];

        boolean[][] vis = new boolean[m][n];

        Queue<Pair> q = new LinkedList<>();

        // Put all 1's in queue
        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 1) {

                    q.add(new Pair(i, j));

                    vis[i][j] = true;

                    ans[i][j] = 0;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {

            Pair curr = q.poll();

            int crow = curr.row;
            int ccol = curr.col;

            for(int i = 0; i < 4; i++) {

                int nrow = crow + drow[i];
                int ncol = ccol + dcol[i];

                if(nrow >= 0 &&
                   nrow < m &&
                   ncol >= 0 &&
                   ncol < n &&
                   !vis[nrow][ncol]) {

                    vis[nrow][ncol] = true;

                    ans[nrow][ncol] = ans[crow][ccol] + 1;

                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < m; i++) {

            ArrayList<Integer> row = new ArrayList<>();

            for(int j = 0; j < n; j++) {
                row.add(ans[i][j]);
            }

            result.add(row);
        }

        return result;
    }
}


public class DistanceWithNearestCell {
    
}
