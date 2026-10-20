class Solution {
    int N;
     static final int MOD = 1_000_000_007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        N=n;
        int dp[][][] = new int [101][101][101];
        for(int [][]matrix :dp){
            for(int []row : matrix){
                Arrays.fill(row,-1);
            }
        }
        return solve(0,0,0,minProfit,group,profit,dp);
    }

    private int solve (int idx ,int profits,int people, int minProfit, int[] group, int[] profit,  int dp[][][]){
        if(people>N){
            return 0;
        }
        
        if(idx == group.length){
            if(profits>=minProfit){
                return dp[idx][profits][people]=1;
            }
            return dp[idx][profits][people]= 0;
        }
        if(dp[idx][profits][people]!=-1) return dp[idx][profits][people];

        long notTake = solve(idx+1,profits,people,minProfit,group,profit,dp);

        long take = solve(idx+1,Math.min(profits+profit[idx],minProfit),people+group[idx],minProfit,group,profit,dp);
        long ans = (take + notTake) %MOD;
    return dp[idx][profits][people]=(int)ans;
    }
}