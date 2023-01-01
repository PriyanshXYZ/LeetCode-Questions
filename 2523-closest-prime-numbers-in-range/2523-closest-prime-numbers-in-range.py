class Solution {
    boolean[] isPrime = new boolean[1000001];
    
    public void sieve(){
        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i = 2; i*i<isPrime.length; i++){
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i)
                    isPrime[j] = false;
            }
        }
    }
    public int[] closestPrimes(int left, int right) {
        sieve();
        int a2=-1;
        int[] ans = new int[2];
        Arrays.fill(ans,-1);
        for(int i= right;i>=left;i--){
            if(isPrime[i]){
                if(a2==-1)a2=i;
                else{
                    if(ans[0]==-1){
                        ans[0]=i;
                        ans[1]=a2;
                    }else{
                        if(ans[1]-ans[0]>=a2-i){
                            ans[0]=i;
                            ans[1]=a2;
                        }
                    }
                    a2=i;
                }
            }
        }
        return ans;
    }
}