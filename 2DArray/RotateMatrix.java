/*48. Rotate Image
Medium
Topics
premium lock icon
Companies
You are given an n x n 2D matrix representing an image,
rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place,
which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.
 */


class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

       // swap
        for (int row = 0; row < n; row++) {
            for (int column = row + 1; column < n; column++) {
                int value = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = value;
            }
        }
        // reverse
        for (int row = 0; row < n; row++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int value = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = value;
                left++;
                right--;
            }
        }
        }
    }


public class RotateMatrix {
    
}
