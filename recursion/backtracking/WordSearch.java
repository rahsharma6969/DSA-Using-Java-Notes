/*

79. Word Search
Medium
Topics
premium lock icon
Companies
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

*/


class Solution {

    private boolean isSafe(int i, int j, int n, int m) {

        return i >= 0 && i < n && j >= 0 && j < m;

    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (backtrack(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (!isSafe(i, j, board.length, board[0].length) || visited[i][j] || board[i][j] != word.charAt(index)) { // when all conditions are not satisfied, return false
            return false;
        }
        visited[i][j] = true;
        boolean found = backtrack(board, word, visited, i + 1, j, index + 1) || // down
                        backtrack(board, word, visited, i - 1, j, index + 1) || // up
                        backtrack(board, word, visited, i, j + 1, index + 1) || // right
                        backtrack(board, word, visited, i, j - 1, index + 1); // left
        visited[i][j] = false;
        return found;
    }
}


public class WordSearch {
    
}
