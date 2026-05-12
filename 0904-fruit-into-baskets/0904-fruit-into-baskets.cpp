class Solution {
public:
    int totalFruit(vector<int>& fruits) {
       int left =0,right=0,maxlen=0;
       int n = fruits.size();
       unordered_map<int,int>map;
       while(right<n){
        map[fruits[right]] ++;
        if(map.size() >2){
            map[fruits[left]]--;
            if(map[fruits[left]] ==0){
                map.erase(fruits[left]);
            }
            left++;
        }
        if(map.size() <= 2){
            maxlen = max(maxlen,right-left+1);
        }
        right++;
       } 
       return maxlen;
    }
};