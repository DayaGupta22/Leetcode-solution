class Solution {
public:
    int minimumDistance(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int,vector<int>>mp;
        int res= INT_MAX;
        for(int i=0;i<n;i++){
            mp[nums[i]].push_back(i);
        }

        for(auto &it :mp){
            vector<int>&vec = it.second;
            if(vec.size() <3){
                continue;
            }
            for(int i=0;i<=vec.size()-3;i++){
                int i1 = vec[i];
                int i3 = vec[i+2];
                int k = 2*(i3-i1);
                res = min({res , k});
            }
        }
        return res == INT_MAX?-1:res;
    }
};