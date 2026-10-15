class Solution {
    public int rob(int[] nums) {
        int[]dp = new int[nums.length+1];
        int n = nums.length;
        Arrays.fill(dp,-1);
        return HouseRobbingMaxMoney(nums,0,dp,n);
    }
    private int  HouseRobbingMaxMoney(int[] nums,int i, int[] dp,int n){
        // base case 
       
        if(i >n){
            return 0;
        }
        if(i ==n)return 0;
        if(dp[i]!=-1) return dp[i];

        int include = nums[i]+HouseRobbingMaxMoney(nums,i+2,dp,n);
         int exclude = HouseRobbingMaxMoney(nums,i+1,dp,n);
      
         return dp[i]=Math.max(include,exclude);
    }
}