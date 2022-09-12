class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] ugly=new long[n+1];
        Arrays.fill(ugly,Integer.MAX_VALUE);
        
        ugly[1]=1;
        int[] aIdx=new int[primes.length];
        Arrays.fill(aIdx,1);
        
        
        for(int i=2;i<=n;i++){
            for(int idx=0;idx<aIdx.length;idx++){
                ugly[i]=Math.min(ugly[aIdx[idx]] * primes[idx],ugly[i]);
            }
            for(int idx=0;idx<aIdx.length;idx++){
                if(ugly[i]==ugly[aIdx[idx]] * primes[idx]){
                    aIdx[idx]++;
                }
            }
        }
        return (int)ugly[n];
    }
}