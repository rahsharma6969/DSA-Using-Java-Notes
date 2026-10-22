class Solution {
    // Returns true if target exists in matrix, false otherwise

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;
       

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / cols;
            int c = mid % cols;

            if(matrix[r][c] == target) {
                return true;
            } else if(matrix[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
       


        return false;
    }
}

public class SearchInTwoDMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        Solution solution = new Solution();
        int target = 3;
        boolean found = solution.searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + found);
    }
}
