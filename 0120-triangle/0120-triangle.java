class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int[n][n];
        for(int []mat : dp){
            Arrays.fill(mat,-1); 
        }
        // return solve(0,0,triangle,dp);
        return solveTB(triangle);

    }

    private  int solve(int i ,int j ,List<List<Integer>> triangle,int [][]dp){
        int n = triangle.size();
       
        if(i== triangle.size()-1) return triangle.get(n-1).get(j);
         if(dp[i][j]!=-1) return dp[i][j];
        int d =triangle.get(i).get(j) + solve(i+1,j,triangle,dp);
         int dia =triangle.get(i).get(j) + solve(i+1,j+1,triangle,dp);
         return dp[i][j]= Math.min(d,dia);
    }

    private int solveTB(List<List<Integer>> triangle){
          int n = triangle.size();
        int [][] dp = new int[n][n];
        for(int []mat : dp){
            Arrays.fill(mat,-1); 
        } 
        for(int j=0;j<n;j++){
            dp[n-1][j]= triangle.get(n-1).get(j);        
        }

        for(int i=n-2;i>=0;i--){
            for(int j= i;j>=0;j--){
                    int d =triangle.get(i).get(j) + dp[i+1][j];
                    int dia =triangle.get(i).get(j) + dp[i+1][j+1];
                    dp[i][j]= Math.min(d,dia);
            }
        }
        return dp[0][0];

    }
}