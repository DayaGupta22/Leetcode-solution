class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {






     int m = obstacleGrid.length;        // number of rows
int n = obstacleGrid[0].length;     // number of columns
        int [][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j] ==1) dp[i][j]=0;
                else if( i==0 && j==0) dp[i][j]=1;
                else{
                    int up =0,left=0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j]= up +left;
                }
            }
        }
        return dp[m-1][n-1];

        // return solve(m-1,n-1,dp,obstacleGrid);
    }
    private int solve(int row,int col ,int [][] dp,int[][] Grid){
        if(row>=0 && col>=0 && Grid[row][col] == 1) return 0;
        if(row ==0 && col ==0) return 1;
        if(row<0 || col<0) return 0;
     if(dp[row][col] != -1 )return dp[row][col];
        int up = solve(row-1,col,dp,Grid);
        int left = solve(row,col-1,dp,Grid);
        return dp[row][col]=up+left;




    }

}