class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][]dp = new int [coins.length+1][amount+1];
       for (int[] row : dp) {
    Arrays.fill(row, -1);
}

        int ans= MinCoins(coins,amount,dp,coins.length-1);

        if(ans >= Integer.MAX_VALUE){
            return -1;
        }
        else 
            return ans;
    }
    private int MinCoins(int [] coins,int amount,int [][] dp,int n ){
        if(n ==0){
            if(amount %coins[0] == 0) return  amount/coins[0]; 
            else {
                return Integer.MAX_VALUE;
            }
        }
        if(dp[n][amount] !=-1) return dp[n][amount];

         int noTake = 0 + MinCoins(coins,amount,dp,n-1);

         int take = Integer.MAX_VALUE;

         if(coins[n]<= amount){
            int result= MinCoins(coins,amount-coins[n],dp,n);
            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
         }

         return dp[n][amount]=Math.min(take,noTake);
    }
}