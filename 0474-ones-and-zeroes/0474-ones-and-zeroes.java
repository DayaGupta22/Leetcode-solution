class Solution {
     class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private int solve ( ArrayList<Pair> list ,int m , int n ,int i,int[][][] t  ){
        if((m ==0 && n==0) || i>=list.size()){
            return 0;
        }
        if(t[m][n][i] !=-1) return t[m][n][i];

        int take =0;

        if(list.get(i).first<=m  && list.get(i).second<=n){
            take = 1+solve(list,m-list.get(i).first,n-list.get(i).second,i+1 ,t);
        }
        int skip=solve(list,m,n,i+1,t);
        return t[m][n][i] =Math.max(take,skip);
    }

 private int Solve(
            String[] strs,
            int m,
            int n,
            int index, int dp[][][]) {

        if (index == strs.length) {
            return 0;
        }

        if (dp[index][m][n] != -1) {
            return dp[index][m][n];
        }

        int zeros = 0;
        int ones = 0;

        for (char ch : strs[index].toCharArray()) {
            if (ch == '0') {
                zeros++;
            } else {
                ones++;
            }
        }

        // Skip
        int skip = Solve(
                strs,
                m,
                n,
                index + 1,dp
        );

        // Take
        int take = 0;

        if (zeros <= m && ones <= n) {

            take = 1 + Solve(
                    strs,
                    m - zeros,
                    n - ones,
                    index + 1,dp
            );
        }

        return dp[index][m][n] =
                Math.max(take, skip);
    }





    public int findMaxForm(String[] strs, int m, int n) {
    int[][][] t = new int[601][101][101];

    for (int[][] matrix : t) {
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }
    }
        return Solve(strs,m,n,0 ,t);
    }
}