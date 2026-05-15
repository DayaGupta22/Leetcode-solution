class Solution {
    private void findcombi(int index, int target,int[] nums ,List<List<Integer>>ans ,List<Integer>ds){
        if(index == nums.length){
            if (target ==0){
               ans.add(new ArrayList<>(ds));

            }
            return;
        }
        // agar hai toh pickarna 
        if(nums[index] <= target){
            ds.add(nums[index]);
            findcombi(index,target-nums[index], nums,ans,ds);
            ds.remove(ds.size()-1);
        }
        // not pick
        findcombi(index+1,target,nums,ans,ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<  List<Integer>>ans = new ArrayList<>();
        findcombi(0,target,candidates,ans,new ArrayList<>());
        return ans;
    }
}