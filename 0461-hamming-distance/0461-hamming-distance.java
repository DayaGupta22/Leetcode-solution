class Solution {
    public int hammingDistance(int x, int y) {
        int setbit = x^y;int count =0;

        while(setbit!=0){
            setbit = (setbit & setbit-1);
            count++;
        }
        return count ;
    }
}