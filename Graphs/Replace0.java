/*
Replace O's with X's
Difficulty: MediumAccuracy: 34.0%Submissions: 139K+Points: 4Average Time: 20m
You are given a grid[][] of size n*m, where every element is either 'O' or 'X'. You have to replace all 'O' or a group of 'O' with 'X' that are surrounded by 'X'.

A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.

Examples:

Input: 
grid[][] = [['X', 'X', 'X', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'O', 'O', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'X', 'O', 'O']]
Output: 
[['X', 'X', 'X', 'X'], 
['X', 'X', 'X', 'X'], 
['X', 'X', 'X', 'X'], 
['X', 'X', 'X', 'X'], 
['X', 'X', 'O', 'O']]
Explanation: We only changed those 'O' that are surrounded by 'X' */
// using bfs
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
    public void fill(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        // Add all boundary O's.
        //  These and all O's connected to them cannot be replaced.
        for(int i=0; i<n; i++) {
            if(grid[i][0] == 'O') { // first column
                visited[i][0] = true;
                q.add(new Pair(i, 0));
            }
            if(grid[i][m - 1] == 'O') { // last column
                visited[i][m - 1] = true;
                q.add(new Pair(i, m - 1));
            }
        }

        for(int j=0; j<m; j++) { // first row and last row
            if(grid[0][j] == 'O') {
                visited[0][j] = true;
                q.add(new Pair(0, j));
            }
            if(grid[n - 1][j] == 'O') {
                visited[n - 1][j] = true;
                q.add(new Pair(n - 1, j));
            }
        }
        // BFS to find all O's connected to boundary O's.
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int crow = curr.row;
            int ccol = curr.col;

            for(int i=0; i<4; i++) {
                int nrow = crow + drow[i];
                int ncol = ccol + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && grid[nrow][ncol] == 'O' && !visited[nrow][ncol]) {
                    visited[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 'O' && !visited[i][j]) {
                    grid[i][j] = 'X';
                }
            }
        }
    }
}


public class Replace0 {
    
}
