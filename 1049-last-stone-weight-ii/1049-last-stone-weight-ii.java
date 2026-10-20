class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int total=0;
        for(int stone:stones){
            total += stone;
        }
        int target = total/2;

        boolean[][]dp = new boolean [n+1][target+1];
        dp[0][0]= true;
        for(int i=1;i<=n;i++){
            int stone = stones[i-1];
            for(int j =0;j<=target;j++){

                // dont take
                dp[i][j]= dp[i-1][j];
                if(stone<=j){
                    // take
                    dp[i][j]= dp[i-1][j-stone] || dp[i-1][j];
                }
            }
        } // find the berst largest possible subset sum in the last row of each colummn 
         int best =0;
        for(int j = target;j>=0;j--){
            if(dp[n][j]){
                best =j;
                break;
            }
        }
        int other = total-best;
        return other - best;

    }
}