class Solution {
public:
    int minMirrorPairDistance(vector<int>& nums) {
        int n= nums.size();
        int res = INT_MAX;
        unordered_map<int,int>mp;
        for(int i=0;i<n;i++){
        
        // for(int j=1;j<n;j++){
        //     if ( i<j && result== nums[j]){
        //        res=  min(res,abs(i-j));
        //     }
        // }
            if(mp.count(nums[i])){
                res = min(res, abs(i - mp[nums[i]]));
            }
            int rev=reverse(nums[i]);
            // store current number
            mp[rev] = i;

        }
        return res == INT_MAX?-1:res;
    }
    private: int reverse(int num){
        int rev =0;
        while(num>0){
            
            rev = rev*10+num%10;
            num /=10;
        }
        return rev;
    }
};

