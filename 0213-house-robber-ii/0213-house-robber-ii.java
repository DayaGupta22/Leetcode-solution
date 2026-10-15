class Solution {
    public int rob(int[] nums) {
        int [] dp = new int [nums.length+1];
        int n = nums.length;
          if (n == 1) {
            return nums[0];
        }
int[] dp1 = new int[n + 1];
        Arrays.fill(dp1, -1);
        int include = HouseRobbingMax(nums, dp1, 0, n - 2);

        int[] dp2 = new int[n + 1];
        Arrays.fill(dp2, -1);
        int exclude = HouseRobbingMax(nums, dp2, 1, n - 1);
        return Math.max(include , exclude);
    }
    private int HouseRobbingMax(int []nums,int[] dp,int i,int n){
        if (i>n){
            return 0;
        }

        if(dp[i]!=-1) return dp[i];

        int include = nums[i]+HouseRobbingMax(nums,dp,i+2,n);
        int exclude= HouseRobbingMax(nums,dp,i+1,n);

        return dp[i]= Math.max(include,exclude);
    }
}