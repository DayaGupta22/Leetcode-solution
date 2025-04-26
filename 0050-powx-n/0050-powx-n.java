class Solution {
    public double myPow(double x, int n) {
        long binform = n;
        if(n==0) return 1.0;
        if(x==0) return 0.0;
        if(x == 1) return 1.0;
        if(binform <0){
            x = 1/x;
            binform=-binform;
        }
        double ANS =1;
        while(binform >0){
            if(binform %2 == 1){
                ANS *=x;
            }
            x *= x;
            binform /= 2;
        }
        return ANS;
    }
}