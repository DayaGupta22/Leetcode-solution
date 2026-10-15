class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Initialize DP table
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Base case: amount 0 requires 0 coins
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int t = 1; t <= amount; t++) {

                // Do not take the current coin
                int noTake = dp[i - 1][t];

                // Take the current coin
                int take = Integer.MAX_VALUE;

                if (coins[i - 1] <= t &&
                    dp[i][t - coins[i - 1]] != Integer.MAX_VALUE) {

                    take = 1 + dp[i][t - coins[i - 1]];
                }

                dp[i][t] = Math.min(take, noTake);
            }
        }

        int ans = dp[n][amount];

        return ans == Integer.MAX_VALUE ? -1 : ans;
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