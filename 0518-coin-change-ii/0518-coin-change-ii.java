class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int [coins.length+1][amount+1];
       for(int[] row :dp){
        Arrays.fill(row,-1);
       }
        return CoinChange(coins.length-1,amount,coins,dp);
    } 
    private int CoinChange(int index , int target ,int[] amount,int [][] dp){
        if (index == 0) {
        return target % amount[0] == 0 ? 1 : 0;
    }
    if(dp[index][target] != -1) return dp[index][target];
        int notTake = 0 + CoinChange(index-1,target,amount,dp);
        int take=0;
        if(amount[index]<=target ){
             take = CoinChange(index, target-amount[index],amount,dp);
        }
        return dp[index][target]= take + notTake;

    }
}