/*Set Matrix Zeroes
Subscribe to TUF+

Hints
Company
Given an m x n integer matrix matrix, if an element is 0,
set its entire row and column to 0. You must do it in place.


Example 1

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]

Explanation:

Element at position (1,1) is 0, so set entire row 1 and column 1 to 0.

Example 2

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]

Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Explanation:

There are two zeroes: (0,0) and (0,3).

Row 0 → all elements become 0
Column 0 and column 3 → all elements become 0
 */


class Solution {
    // 
    public void setZeroes(int[][] matrix) {
        // time complexity is O(m*n) and space complexity is O(m+n)
        // space complexity is O(m+n) because we are using two boolean arrays to 
        // keep track of which rows and columns should be set to zero.
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] rowZero = new boolean[rows];
        boolean[] colZero = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               if(rowZero[i] == true || colZero[j] == true) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

public class SetMatrixZeros {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        sol.setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}