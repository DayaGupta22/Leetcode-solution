class Solution {
      int max = Integer.MIN_VALUE;
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
         int [][]dp = new int[m][n];
         for(int []mat : dp){
           
            Arrays.fill(mat,-1);
         }
        //  solve (0,0,matrix,dp);
        solveTb(matrix);
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
    private int solveTb(char [][] mat){
            int m = mat.length; //row
            int n = mat[0].length; //col
            int [][]dp = new int[m+1][n+1];
            for(int []mati : dp){ 
            Arrays.fill(mati,0);
            }
            for(int i =m-1;i>=0;i--){
                for(int j= n-1;j>=0;j--){
 if(i<0 || j<0){
            dp[i][j]= 0;
        }

                        int right = dp[i][j+1];
                         int down = dp[i+1][j];
                         int diago=dp[i+1][j+1];

                        if(mat[i][j] =='1'){
                            dp[i][j] = 1 + Math.min(right,Math.min(down,diago));
                            max= Math.max(dp[i][j],max);
                            
                        } else {
                            dp[i][j]= 0;
                        }
                                }
            }


return dp[0][0];

    } 


}