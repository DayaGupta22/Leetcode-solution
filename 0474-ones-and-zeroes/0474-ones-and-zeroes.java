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

    public int findMaxForm(String[] strs, int m, int n) {
    int[][][] t = new int[101][101][601];

    for (int[][] matrix : t) {
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }
}
        int N = strs.length;
        ArrayList<Pair>list = new ArrayList<>();
        for(int i =0;i<N;i++){
            int zero =0;
            int one=0;
            for(char ch: strs[i].toCharArray()){
                if(ch =='0'){
                    zero++;
                } else one++;

            }
            list.add(new Pair(zero,one));
        }
        return solve(list,m,n,0 ,t);
    }
}