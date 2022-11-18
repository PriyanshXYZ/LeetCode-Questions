class Solution {
    public boolean isUgly(int n) {
        if(n==0)return false;
        int factor=2;
        
        while(n%factor==0){
            n=n/factor;
        }
        factor=3;
        while(n%factor==0){
            n=n/factor;
        }
        factor=5;
        while(n%factor==0){
            n=n/factor;
        }
        if(n==1)return true;
        else return false;
    }
}