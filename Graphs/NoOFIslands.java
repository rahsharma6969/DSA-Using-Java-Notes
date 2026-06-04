/*
Given an n × m grid[][] consisting of 'L' (land) and 'W' (water), we need to count the 
total number of islands present in the grid without modifying the original grid.
An island is defined as a group of connected 'L' cells that are adjacent horizontally,
 vertically, or diagonally, and surrounded by water or the boundary of the grid.

Examples:

Input: grid[][] =       [['L', 'L', 'W', 'W', 'W'],
                        ['W', 'L', 'W', 'W', 'L'],
                        ['L', 'W', 'W', 'L', 'L'],
                        ['W', 'W', 'W', 'W', 'W'],
                        ['L', 'W', 'L', 'L', 'W']]
Output: 4
Explanation: The image below shows all the 4 islands.
Input: grid[][] =           [['L', 'W', 'W', 'L', 'W'],
                            ['L', 'W', 'W', 'L', 'L'],
                            ['W', 'L', 'W', 'L', 'W'],
                            ['W', 'W', 'W', 'W', 'W'],
                            ['L', 'L', 'L', 'W', 'L']]

*/

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public void bfs(int row, int col, boolean[][] visited, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        visited[row][col] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            int[] r_dir = { -1, 0, 1, 0, -1, -1, 1, 1 };
            int[] c_dir = { 0, 1, 0, -1, -1, 1, -1, 1 };

            for (int i = 0; i < 8; i++) {
                int nrow = curr.row + r_dir[i];
                int ncol = curr.col + c_dir[i];
                if (nrow >= 0 && nrow < grid.length && ncol >= 0 &&
                        ncol < grid[0].length && grid[nrow][ncol] == 'L' && !visited[nrow][ncol]) {
                    visited[nrow][ncol] = true;
                    q.offer(new Pair(nrow, ncol));
                }

            }
        }
    }

    public int numIslands(char[][] grid) {
        // Implementation for counting islands
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L' && !vis[i][j]) {
                    bfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }
}

public class NoOFIslands {

}
