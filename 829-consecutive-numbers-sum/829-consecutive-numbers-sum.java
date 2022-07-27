class Solution {
    public int consecutiveNumbersSum(int n) {
        int res=0;
        int x=1;
        int eqn=x * (x - 1)/2;
        while(eqn < n){
            if((n-eqn) % x==0 ){
                res++;
            }
            x++;
            eqn=x * (x - 1)/2;
        }
        return res;
    }
}