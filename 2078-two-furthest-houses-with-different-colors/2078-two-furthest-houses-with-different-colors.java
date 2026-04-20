class Solution {
    public int maxDistance(int[] colors) {
        int ans=Integer.MIN_VALUE;
        int n = colors.length;
        int j=n-1;
       for(int i=0;i<n;i++){
        if(colors[i]!=colors[j]){
            ans = Math.max(ans,j-i);
            break;
        }
       }
       for(int i=n-1;i>=0;i--){
        if(colors[0]!=colors[i]){
            ans = Math.max(ans,i);
            break;
        }
       }
       return ans;

    }
}