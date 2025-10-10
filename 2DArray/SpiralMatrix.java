import java.util.*;

public class SpiralMatrix {
    static int [] spiral(int[][] mat){
        int m = mat.length; // no of rows
        int n  = mat[0].length; // no of columns
        int srow = 0;
        int scol = 0;
        int erow = m-1;
        int ecol = n-1;
        int[] ans = new int[m*n];
        int idx = 0;
        while(srow < erow && scol < ecol){

            // top
            for(int i = scol; i <= ecol; i++){
                ans[idx++] = mat[srow][i];
            }
            //right
            for(int i = srow + 1; i <= erow; i++){
                ans[idx++] = mat[i][ecol];
            }


            //bottom
            for(int i=ecol - 1; i >= scol; i--){
                ans[idx++] = mat[erow][i];
            }


            //left
            for(int i= ecol - 1; i >= scol + 1; i--){
                ans[idx++] = mat[i][scol];
            }

            srow++;
            scol++;
            erow--;
            ecol--;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        int[]result = spiral(matrix);
        System.out.println("Spiral Order: " + Arrays.toString(result));
    }
}
