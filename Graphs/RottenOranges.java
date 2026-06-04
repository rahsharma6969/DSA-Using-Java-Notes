import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int time;

    public Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        boolean[][] vis = new boolean[n][m];

        int fresh = 0;

        // Put all rotten oranges into queue
        for(int i = 0; i < n; i++) {

            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 2) {

                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = true;
                }

                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[] r_dir = {-1, 0, 1, 0};
        int[] c_dir = {0, 1, 0, -1};

        int count = 0;
        int time = 0;

        while(!q.isEmpty()) {

            Pair curr = q.poll();

            int row = curr.row;
            int col = curr.col;
            int tm = curr.time;

            time = Math.max(time, tm);

            for(int i = 0; i < 4; i++) {

                int nrow = row + r_dir[i];
                int ncol = col + c_dir[i];

                if(nrow >= 0 && nrow < n &&
                   ncol >= 0 && ncol < m &&
                   grid[nrow][ncol] == 1 &&
                   !vis[nrow][ncol]) {

                    vis[nrow][ncol] = true;

                    q.offer(new Pair(nrow, ncol, tm + 1));

                    count++;
                }
            }
        }

        if(count != fresh) {
            return -1;
        }

        return time;
    }
}

public class RottenOranges {

}