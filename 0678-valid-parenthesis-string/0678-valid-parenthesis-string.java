class Solution {
    public boolean checkValidString(String s) {
      Boolean [][] dp = new Boolean[s.length()+1][s.length()+1];
        
        return solve(s,0,0,dp);
    }
    private boolean solve(String s,int ind,int count, Boolean[][] dp){
        if(count<0) return false;
      
        if(ind == s.length()) { return count ==0;}
          if(dp[ind][count] != null) return dp[ind][count];
        if(s.charAt(ind )=='(') return dp[ind][count]=solve(s,ind+1,count+1,dp);
        if(s.charAt(ind)==')') return dp[ind][count]=solve(s,ind+1,count-1,dp);
        dp[ind][count]=(solve(s,ind+1,count-1,dp)||
        solve(s,ind+1,count+1,dp)||
        solve(s,ind+1,count,dp)
        );
        return dp[ind][count];
    }
}