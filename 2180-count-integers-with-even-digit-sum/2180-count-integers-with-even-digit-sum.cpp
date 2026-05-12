class Solution {
public:
    int isdigitsum(int num){
        int sum =0;
        while(num!=0){
            int digit = num%10;
            sum+=digit;
            num= num/10;
        }
        return sum;
    }

    int countEven(int num) {
        int count =0;
        int i=2;

        while(i<=num){
           int sum= isdigitsum(i);
           if(sum %2 ==0){
            count ++;
           }
           i++;
        }
        return count ;

    }
};