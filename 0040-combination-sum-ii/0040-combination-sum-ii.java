
class Solution {
    private void findcombi(int index, int target,int[] nums ,List<List<Integer>>ans ,List<Integer>ds){
            if (target == 0){
               ans.add(new ArrayList<>(ds));
                  return;
            }
         for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>target){
                break;
            }
            ds.add(nums[i]);

            findcombi(i+1,target-nums[i],nums,ans,ds);

            ds.remove(ds.size()-1);
         }

       
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      List<  List<Integer>>ans = new ArrayList<>();
      Arrays.sort(candidates);
    findcombi(0,target,candidates,ans,new ArrayList<>());
    return ans;
    }
}