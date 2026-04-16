class Solution {
public:
    vector<int> solveQueries(vector<int>& nums, vector<int>& queries) {
        int n = nums.size();
        unordered_map<int,vector<int>>mp;
        for(int i=0;i<n;i++){
            mp[nums[i]].push_back(i); //{1{0,2,4}{3{0,5}}
        }
         vector<int>result;
        for(int qi:queries){
            int element= nums[qi];// element of nums by index of queries index
            vector<int>&vec = mp[element];

            int size = vec.size();
            //no more occurence of eleemnt 
            if(size ==1){
                result.push_back(-1);
                continue;
            }

            int pos = lower_bound(begin(vec), end(vec),qi)-begin(vec);
            int res = INT_MAX;

            // right neighbour
            int right = vec[(pos+1)%size];
            int d = abs(qi-right); // straight forward distance 
            int circular = n-d;
            res = min({res, d, circular});

            //left
             int left = vec[(pos-1+size)%size]; // fror cicular check 
             d = abs(qi-left); // straight forward distance 
             circular = n-d;
            res = min({res,d,circular});
            
            result.push_back(res);

        }
        return result;

    }
};