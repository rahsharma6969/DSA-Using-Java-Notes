import java.util.*;

public class SpiralMatrix {
    
    static int [] spiral(int[][] matrix){
        List<Integer> ans = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;

        int srow = 0;
        int scol = 0;

        int erow = matrix.length - 1;
        int ecol = matrix[0].length - 1;

        while(srow <= erow && scol <= ecol){
            // top
            for(int i = scol; i <= ecol; i++){
                ans.add(matrix[srow][i]);
            }
            srow++;

            // right
            for(int i = srow + 1; i <= erow; i++){
                ans.add(matrix[i][ecol]);
            }
            ecol--;

            // bottom
            if(srow <= erow){
                for(int i = ecol - 1; i >= scol; i--){
                    ans.add(matrix[erow][i]);
                }
                erow--;
            }

            // left
            if(scol <= ecol){
                for(int i = erow; i >= srow + 1; i--){
                    ans.add(matrix[i][scol]);
                }
                scol++;
            }
        }

        // Convert the list to an array
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
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
