class Solution {
    public int fib(int n) {
        if(n==0 || n==1)return n;
        int a=0;
        int b=1;
        
        int count=1;
        while(true){
            int c=a+b;
            a=b;
            b=c;
            if(count++==n)break;
        }
        return a;
    }
}