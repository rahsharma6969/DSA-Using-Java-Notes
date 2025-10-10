import java.util.*;


class Solution {
    int MaxRowSum(int matrix[][]) {

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                rowSum += matrix[i][j];
            }
            maxSum = Math.max(maxSum, rowSum);

        }
        return maxSum;
    }

    int MaxColSum(int matrix[][]) {

        int maxSum = Integer.MIN_VALUE;

        for (int j = 0; j < matrix[0].length; j++) {
            int colSum = 0;
            for (int i = 0; i < matrix.length; i++) {
                colSum += matrix[i][j];
            }
            maxSum = Math.max(maxSum, colSum);

        }
        return maxSum;
    }
   //Brute Force Approach
    int DiagonalSum(int matrix[][]) {
        int sum = 0;
        for (int i=0; i<matrix.length; i++){
            for(int j=0;j<matrix[0].length; j++){
                if (i==j){
                    sum += matrix[i][j];
                }
                else if (j == matrix[0].length - i -1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
    //Optimal Approach
    int DiagonalSumOptimal(int matrix[][]) {
        int sum = 0;
        for (int i=0; i<matrix.length; i++){
         
            sum += matrix[i][i];
            if (i != matrix.length - i -1){ // to avoid double counting in odd dimension matrix
                sum += matrix[i][matrix.length - i -1];
            }
        }
        return sum;
    }

}

public class TwoDArray {
    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 20, 3 },
                { 4, 40, 6 },
                { 7, 18, 9 }
        };
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Row Sum
        Solution sol = new Solution();
    
        System.out.println("Maximum Row Sum: " + sol.MaxRowSum(matrix));
        System.out.println("Maximum Column Sum: " + sol.MaxColSum(matrix));
        System.out.println("Diagonal Sum: " + sol.DiagonalSum(matrix));

    }
}
