class Solution {
public:
    int minimumDistance(vector<int>& nums) {
        vector<int>vec;
        int n = nums.size();
        unordered_map<int ,vector<int>>mp;
        for(int i=0;i<n;i++){
            mp[nums[i]].push_back(i);
        }
       
        int ans=INT_MAX;

        for(auto &it :mp){
            vector<int>&vec = it.second;
            if(vec.size()<3){
                continue;
            }
            for(int i=0;i<=vec.size()-3;i++){
                int i1= vec[i];
                int i3=vec[i+2];
                int dist = 2*(i3-i1);


                ans= min({ans,dist});
            }
        }
        return ans == INT_MAX?-1:ans;

        
    }
};