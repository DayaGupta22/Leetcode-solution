class Solution {
    private int  solve(
            int col,
            char[][] board,
            int[] leftRow,
            int[] upperDiagonal,
            int[] lowerDiagonal,
            int n) {

        // All queens are placed
        if (col == n) {
            return 1;
        } 
        int count=0;

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
               count+= solve(
                    col + 1,
                    board,
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
        return count;
            }
    public int totalNQueens(int n) {

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
       int ans= solve(
            0,
            board,
            leftRow,
            upperDiagonal,
            lowerDiagonal,
            n
        );

        return ans;
    }

}