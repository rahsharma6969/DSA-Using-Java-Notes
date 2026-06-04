/*
733. Flood Fill
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:

Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.

 

Example 1:

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2

Output: [[2,2,2],[2,2,0],[2,0,1]]

Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected by a path of the
same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 */

import java.util.LinkedList;
import java.util.Queue;


class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row= row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int orgColor = image[sr][sc];
        if(orgColor == color) return image;
        int m = image.length;
        int n = image[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];


        q.add(new Pair(sr , sc));
        vis[sr][sc] = true;
        image[sr][sc]  = color;
       
        
        while(!q.isEmpty()) {
            Pair curr  =  q.poll();
            int crow = curr.row;
            int ccol = curr.col;

            int [] drow= {-1, 0 , 1, 0};
            int [] dcol = {0, 1,0 , -1 };

            for(int i=0; i<4; i++){
               int nrow = drow[i] + crow;
               int ncol = dcol[i] + ccol;

               if(nrow >=0 && nrow <image.length && ncol >=0 &&
                ncol <image[0].length && !vis[nrow][ncol] && image[nrow][ncol] == orgColor ) {
                    vis[nrow][ncol] = true;
                    image[nrow][ncol]  = color;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        return  image;

    }
}

class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;

        Solution sol = new Solution();
        int[][] result = sol.floodFill(image, sr, sc, color);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}