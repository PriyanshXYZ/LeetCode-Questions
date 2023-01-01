class Solution {
    boolean[] isPrime = new boolean[1000001];
    List<Integer> primes;
    public void sieve(){
        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;
        primes = new ArrayList();
        for(int i = 2; i*i<isPrime.length; i++){
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i)
                    isPrime[j] = false;
            }
        }
    }
    public int[] closestPrimes(int left, int right) {
        sieve();
        for(int i=left;i<=right;i++){
            if(isPrime[i])primes.add(i);
        }
        if(primes.size()<2)return new int[]{-1,-1};
        
        int minDiff= primes.get(1)-primes.get(0);
        int n2=primes.get(1);
        int n1=primes.get(0);
        
        for(int i=2;i<primes.size();i++){
            int diff = primes.get(i) - primes.get(i-1);
            if(diff<minDiff){
                n1=primes.get(i-1);
                n2=primes.get(i);
                minDiff = diff;
            }
        }
        return new int[]{n1,n2};
    }
}