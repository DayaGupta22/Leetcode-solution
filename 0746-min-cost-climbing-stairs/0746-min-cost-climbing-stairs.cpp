class Solution {
public:
int ways(int n , vector<int>&cost , vector<int>&vec){
    if(n<=1){
        return 0;
    } 
    if (vec[n] != -1){
        return vec[n];
    }
    return vec[n]= min( cost[n-1] +ways(n-1,cost,vec) , cost [n-2]+ways(n-2,cost,vec));
}
    int minCostClimbingStairs(vector<int>& cost) {
       
        int n = cost.size();
         vector<int>vec(n+1,-1);
        return  ways(n ,cost,vec);
    }
};