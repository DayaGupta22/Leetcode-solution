class Solution {
    public int maxScore(int[] nums, int k) {
      int leftsum =0,rightsum=0,maxsum =0;
      // for left sum 
      for(int i=0;i<k;i++){
        leftsum +=nums[i];
      }
      maxsum = leftsum;
      int right =nums.length-1;
      for(int i=k-1;i>=0;i--){
        leftsum -= nums[i];
        rightsum += nums[right];
        right--;
         maxsum = Math.max(maxsum ,leftsum + rightsum);
      }
     
      return maxsum;
    }
}