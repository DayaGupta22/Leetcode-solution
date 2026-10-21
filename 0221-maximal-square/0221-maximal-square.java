class Solution {
      int max = Integer.MIN_VALUE;
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
         int [][]dp = new int[m][n];
         for(int []mat : dp){
           
            Arrays.fill(mat,-1);
         }
         solve (0,0,matrix,dp);
         return max *max;
    }
    private int solve (int i,int j , char [][]mat ,int[][] dp){
        if(i>=mat.length || j>=mat[0].length){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int right = solve(i,j+1,mat,dp);
        int down = solve(i+1,j,mat,dp);
        int diago= solve(i+1,j+1,mat,dp);

        if(mat[i][j] =='1'){
            dp[i][j] = 1 + Math.min(right,Math.min(down,diago));
            max= Math.max(dp[i][j],max);
            return dp[i][j];
        } else {
            return dp[i][j]= 0;
        }
    }
}