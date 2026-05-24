class Solution {
    private int solve(int[] arr , int i,int d,int[] dp){
        int result=1;
        int n=arr.length;
        // left side  i-1,i-2
        if(dp[i] != -1){
            return dp[i];
        }
        for(int j=i-1;j>=Math.max(0,i-d); j--){
            if(arr[j]>=arr[i]){
                break;
            }
            result = Math.max(result,1+solve(arr,j,d,dp));

        } 
        // right side i+1 ,i+2 ..i+d
        for(int j=i+1;j<=Math.min(n-1,i+d);j++){
            if(arr[j]>=arr[i]){
                break;
            }
            result = Math.max(result,1+solve(arr,j,d,dp));
        }
        return dp[i]=result;
    }
    public int maxJumps(int[] arr, int d) {
       int n= arr.length;
       int result =1;
       int[] dp = new int[n+1];
       Arrays.fill(dp,-1);
       for(int i=0;i<n;i++){
        result = Math.max(result,solve(arr,i,d,dp ));
       } 
       return result;
    }
}