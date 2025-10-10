class Solution {
    // Returns true if target exists in matrix, false otherwise

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m - 1;
        int row = -1;

        // Binary search to find the possible row
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
                row = mid;
                break;
            } else if (target < matrix[mid][0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (row == -1)
            return false;

        // Binary search in the found row
        start = 0;
        end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (target < matrix[row][mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
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
