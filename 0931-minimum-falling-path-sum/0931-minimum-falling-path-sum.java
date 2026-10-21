// class Solution {
//     public int minFallingPathSum(int[][] a) {
//         int n = a.length;
//         int m= a[0].length;
//         int [][] dp = new int [n][m];
//         for(int []row:dp){
//             Arrays.fill(row,0);
//         }
//          for(int j =0;j<m;j++) dp[0][j] = a[0][j]; // base case 


//         for(int i=1;i<n;i++){
//             for(int j=0;j<m;j++){
//                 int u= a[i][j]+dp[i-1][j]; //up
//                  int  ld= a[i][j];
//                  int rd= a[i][j];
//                 if(j-1>=0)
//                      ld += dp[i-1][j-1];// left diagonal
//                 else ld+= Integer.MAX_VALUE;     
//                 if(j+1<m)
//                     rd += dp[i-1][j+1];
//                    else rd+= Integer.MAX_VALUE;
//                 dp[i][j] = Math.min(u,Math.min(ld,rd));

//             }
//         }
//         int min = Integer.MAX_VALUE;
//         for(int j =0;j<m;j++){
//             min =Math.min(min,dp[n-1][j]);
//         }
//         return min;

//     }
   
// }
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[][] dp = new int[n][n];

        // Base case: first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill DP
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < n; j++) {

                // Up
                int up = dp[i - 1][j];

                // Left diagonal
                int leftDiagonal = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    leftDiagonal = dp[i - 1][j - 1];
                }

                // Right diagonal
                int rightDiagonal = Integer.MAX_VALUE;
                if (j + 1 < n) {
                    rightDiagonal = dp[i - 1][j + 1];
                }

                dp[i][j] = matrix[i][j]
                        + Math.min(up,
                            Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // Minimum value in last row
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }
}