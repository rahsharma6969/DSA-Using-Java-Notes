
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    private int[] dRow = { -1, 0, 1, 0 };
    private int[] dCol = { 0, 1, 0, -1 };
    

    // time compplexity: O(n*m) where n and m are the dimensions of the grid
    // space complexity: O(n*m) in the worst case when all cells are land
    public int countDistinctIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Set<String> uniqueIslands = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    StringBuilder shape = new StringBuilder();
                    bfs(grid, visited, i, j, shape);
                    uniqueIslands.add(shape.toString());
                }
            }
        }

        return uniqueIslands.size();
    }

    private void bfs(char[][] grid, boolean[][] visited, int startRow, int startCol, StringBuilder shape) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startRow, startCol));
        visited[startRow][startCol] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            shape.append(curr.row - startRow).append(",").append(curr.col - startCol).append(";"); // first row and col are relative to the starting point

            for (int i = 0; i < 4; i++) {
                int crow = curr.row;
                int ccol = curr.col;
                int nrow = crow + dRow[i];
                int ncol = ccol + dCol[i];

                if (nrow >= 0 && nrow < grid.length &&
                        ncol >= 0 && ncol < grid[0].length &&
                        grid[nrow][ncol] == '1' &&
                        !visited[nrow][ncol]) {
                    visited[nrow][ncol] = true;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }
    }
}

public class NoOFDistinctIslands {
    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        Solution solution = new Solution();
        int result = solution.countDistinctIslands(grid);
        System.out.println(result); // Output: 3
    }
}
