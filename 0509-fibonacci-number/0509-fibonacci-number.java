class Solution {
    public int fib(int n) {
       int[] dp = new int[n+1];
       Arrays.fill(dp,-1);
        return fibon(n,dp); 
    }
    int fibon(int n ,int[] dp){
        if(n<=1){
            return n;
        } if(dp[n] !=-1){
            return dp[n];
        }
        return dp[n]= fibon(n-1,dp)+fibon(n-2,dp);
    }
}