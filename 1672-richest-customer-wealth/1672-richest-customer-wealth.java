class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int MaxWealth = Integer.MIN_VALUE;
        for(int row =0;row<accounts.length;row++){
            int sum =0;
            for(int col =0;col<accounts[row].length;col++){
                sum +=accounts[row][col];
            }
            MaxWealth= Math.max(sum,MaxWealth);

        }
        return MaxWealth;
    }
}