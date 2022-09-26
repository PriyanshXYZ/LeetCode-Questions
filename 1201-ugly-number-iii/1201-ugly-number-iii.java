class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long lo=1;
        long hi=Integer.MAX_VALUE;
        
        while(lo<hi){
            long mid=lo+(hi-lo)/2;
            
            if(countSmaller(a,b,c,mid)<n){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        return (int)hi;
    }
    private long gcd(long a, long b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private int countSmaller(long a, long b, long c, long num) {
        return (int) ((num / a) + (num / b) + (num / c)
                - (num / lcm(a, b))
                - (num / lcm(b, c))
                - (num / lcm(a, c))
                + (num / lcm(a, lcm(b, c)))); // lcm(a,b,c) = lcm(a,lcm(b,c))
    }
}