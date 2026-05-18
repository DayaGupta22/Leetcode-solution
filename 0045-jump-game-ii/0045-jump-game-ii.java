class Solution {
    public int jump(int[] nums) {
        int l=0,r=0,jumps=0;
        while(r<nums.length-1){
            int far=0;
            for(int i=l;i<=r;i++){
                far = Math.max(i + nums[i],far);
            }
            l=r+1;
            r=far;
            jumps += 1;
        }
        return jumps;
    }
}