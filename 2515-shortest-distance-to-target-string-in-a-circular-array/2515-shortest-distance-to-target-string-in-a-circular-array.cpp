class Solution {
public:
    int closestTarget(vector<string>& words, string target, int startIndex) {
        int res =INT_MAX;
        int sz = words.size();
        for(int i=0; i<sz;i++){
            if(words[i] == target){
                int straight = abs(i-startIndex); 
                int circular = sz-straight;
                res= min({res,straight,circular});
            }
        }
        return res == INT_MAX?-1:res;
    }
};