import java.util.*;

class Solution {

    private void solve(
            int col,
            char[][] board,
            List<List<String>> ans,
            int[] leftRow,
            int[] upperDiagonal,
            int[] lowerDiagonal,
            int n) {

        // All queens are placed
        if (col == n) {

            List<String> current = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }

            ans.add(current);
            return;
        }

        // Try placing queen in every row of current column
        for (int row = 0; row < n; row++) {

            // Check whether queen can be placed
            if (leftRow[row] == 0
                    && lowerDiagonal[row + col] == 0
                    && upperDiagonal[n - 1 + col - row] == 0) {

                // Place queen
                board[row][col] = 'Q';

                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                // Move to next column
                solve(
                    col + 1,
                    board,
                    ans,
                    leftRow,
                    upperDiagonal,
                    lowerDiagonal,
                    n
                );

                // Backtrack
                board[row][col] = '.';

                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        // Create board
        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Row check
        int[] leftRow = new int[n];

        // Diagonal checks
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        // Start from column 0
        solve(
            0,
            board,
            ans,
            leftRow,
            upperDiagonal,
            lowerDiagonal,
            n
        );

        return ans;
    }
}