class Solution {
    public int longestConsecutive(int[] nums) {
        int longest =1;
        int current=1;
        int lastsmaller = Integer.MIN_VALUE;
        if (nums.length== 0)return 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if (nums[i]-1== lastsmaller){
                current+=1;
                lastsmaller= nums[i];
            }
            else if (nums[i]!= lastsmaller){
                current =1;
                lastsmaller=nums[i];
            }
            longest= Math.max(longest ,current);

        }
        return longest;
       
    }
}
