class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int [n][n+1];
        for (int[] row : dp) {
    Arrays.fill(row, -1);
}
         return Solution(0,-1,nums,nums.length,dp);
    }  

    //  private int solution (int index, int prev , int [] nums , int n ){
    //     if(index == n){
    //         return 0;
    //     }
    //     int len= 0+ solution(index+1 , prev , nums,n);
    //     if( prev ==-1 || nums[index] > nums[prev]){
    //         len = Math.max(len ,1+solution(index+1,index, nums, n));
    //     }
    //     return len;

    //  }
      private int Solution (int index, int prev , int [] nums , int n ,int[][]dp){
        if(index == n){
            return 0;
        }
        if(dp[index][prev+1] !=-1) return dp[index][prev+1];
        int len= 0+ Solution(index+1 , prev , nums,n ,dp);
        if( prev ==-1 || nums[index] > nums[prev]){
            len = Math.max(len ,1+Solution(index+1,index, nums, n,dp));
        }
        return dp[index][prev+1]= len;

     }
}