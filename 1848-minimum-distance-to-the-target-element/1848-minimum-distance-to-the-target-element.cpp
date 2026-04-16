class Solution {
public:
    int getMinDistance(vector<int>& nums, int target, int start) {
        int n = nums.size();
        int res = INT_MAX;
        for(int i=0;i<n;i++){
            
            if(nums[i]== target){
                int straight = abs(i-start);
                res= min({res, straight});
            }
            
        }
        for(int i=start;i>=0;i--){
            if(nums[i] == target){
               int straight = abs(i-start);
                res=min({res,straight});
            }
        }
        return res ;

    }
};