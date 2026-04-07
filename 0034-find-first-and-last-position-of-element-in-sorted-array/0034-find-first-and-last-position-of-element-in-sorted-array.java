class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int start = helper(nums ,target ,true);// find first occurece
        int end = helper (nums,target,false);// find last ocuurence
        ans[0]=start;
        ans[1]=end;
        return ans;

    }
    private int helper(int[] nums ,int target, boolean firstIndex){
        int start =0;
        int ans =-1;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if (target>nums[mid]){
                start = mid+1;
            } else if (target <nums[mid]){
                end = mid-1;
            } else{
                ans = mid;
                if(firstIndex){
                    end = mid-1;
                } else{
                    start = mid+1;
                }
            }
        }
        return ans;
    }
}