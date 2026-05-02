class Solution {
public:
vector<int>vec;

 int solve(int num ){
        if (num ==0 ) return vec[num]= 0;
     if(vec[num] !=-1){ return vec[num];}
        int remain = solve(num/10);
        int digit = num %10;
        int digit_check ;
        if(remain ==2) return vec[num]=2;
        if (digit == 0 ||digit== 1 || digit==8){
            digit_check = 0;

        }
        else if (digit ==2 || digit==5 || digit== 6 || digit==9){
            digit_check=1;
        }else {
            return vec[num]= 2;
        }
         if (digit_check ==0 && remain ==0){
            return vec[num]= 0;
        }
        return vec[num]= 1;

    }
    int rotatedDigits(int n) {
        vec.resize(n+1,-1);
        int count =0;
        for(int i =1;i<=n;i++){
            if (solve(i) == 1){
                count ++;
            }
        }
        return count ;
        
    }
};