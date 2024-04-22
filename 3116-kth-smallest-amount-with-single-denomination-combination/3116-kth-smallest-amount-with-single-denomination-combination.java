class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long high = (long)1e18;
        
        while(low < high) {
            long mid = low + (high - low) / 2;
            if(check(coins, mid) < (long)k){
                low = mid + 1;
            }else 
                high = mid;
        }
        return low;
    }
    //use principle of inclusion and exclusion
    public long check(int[] coins, long k) {
        int n = coins.length;
        
        long sum = 0;
        for(int mask = 1; mask < (1<<n); mask++) {
            int setBits = Integer.bitCount(mask);
            long lcm = 1;    
            for(int bit=0;bit<n;bit++){
                if((mask & (1 << bit)) != 0) // we got a common element
                    lcm = lcm(lcm, coins[bit]);
            }
            if(setBits%2==0){
                sum -= k / lcm;
            }else{
                sum += k / lcm;
            }
        }
        return sum;
    }
    long lcm(long a, long b) {
        return (a * b) / hcf(a, b);
    }
    long hcf(long a, long b) {
        if(a==0)return b;
        return hcf(b%a,a);
    }
}