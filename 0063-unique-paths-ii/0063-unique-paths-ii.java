class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
     int m = obstacleGrid.length;        // number of rows
int n = obstacleGrid[0].length;     // number of columns
        int [][] dp = new int[m][n];
        for(int [] row :dp){
            Arrays.fill(row,-1);
        }
        return solve(m-1,n-1,dp,obstacleGrid);
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