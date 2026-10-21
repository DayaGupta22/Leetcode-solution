class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int [][] dp = new int[m][n];
        for(int [] row :dp){
            Arrays.fill(row,-1);
        }
        return solution(m-1,n-1,text1,text2,dp);
    }
    private int solution(int m , int n ,String s1, String s2,  int [][] dp ){
        if(m<0 || n<0) return 0;
        if(dp[m][n] !=-1) return dp[m][n];
        // in case matches
        if(s1.charAt(m) == s2.charAt(n) ) return dp[m][n]=1+solution(m-1,n-1,s1,s2,dp);

        // not matches
         return dp[m][n]=Math.max(solution(m-1,n,s1,s2,dp) , solution(m,n-1,s1,s2,dp));

    }
}