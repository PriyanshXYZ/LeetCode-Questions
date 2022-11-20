class Solution1 {
    public int beautifulPartitions(String s, int k, int minLength) {
        if (k * minLength > s.length() || !isPrime(s.charAt(0)) || isPrime(s.charAt(s.length() - 1))) {
            return 0;
        }
        int[][] dp = new int[s.length() + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 0; i < s.length() - minLength + 1; i++) {
            if (isPrime(s.charAt(i)) && (i == 0 || !isPrime(s.charAt(i - 1)))) {
                for (int j = i + minLength - 1; j < s.length(); j++) {
                    if (!isPrime(s.charAt(j))) {
                        for (int p = 0; p < k; p++) {
                            dp[j + 1][p + 1] += dp[i][p];
                            dp[j + 1][p + 1] %= 1_000_000_007;
                        }
                    }
                }
            }
        }
        return dp[s.length()][k];
    }

    private boolean isPrime(char c) {
        if (c == '2' || c == '3' || c == '5' || c == '7') {
            return true;
        }
        return false;
    }
}
class Solution {
    
    public int beautifulPartitions(String s, int k, int minLen) {
        if(!isPrime(s.charAt(0)-'0') || k * minLen >s.length() || isPrime(s.charAt(s.length()-1)-'0')){
            return 0;
        }
        int[][] cache=new int[s.length()+1][k+1];
        cache[0][0]=1;
        for(int i=0;i<s.length()-minLen+1;i++){
            if(isPrime(s.charAt(i)-'0') && (i==0 || !isPrime(s.charAt(i-1)-'0'))){
                for(int j=i+minLen-1;j<s.length();j++){
                    if(!isPrime(s.charAt(j)-'0')){
                        for(int par=0;par<k;par++){
                            cache[j+1][par+1]+=cache[i][par]%mod;
                            cache[j+1][par+1]%=mod;
                        }
                    }
                }
            }
        }
        return (int)cache[s.length()][k];
        // return (int)memo(0,s,k,minLen,cache);
    }
    int mod=(int)(1e9+7);
    private long memo(int i,String s,int k,int mLen,Integer[][] dp){
        if(k==0 && i==s.length())return 1;
        if(k<0 || i>s.length())return 0;
        if(k==0 || i==s.length())return 0;
        if(!isPrime(s.charAt(i)-'0'))return 0;
        
        if(dp[i][k]!=null)return dp[i][k];
        
        long ans=0;
        
        for(int j=i+mLen-1;j<s.length();j++){
            if(!isPrime(s.charAt(j)-'0')){
                ans=(ans%mod+memo(j+1,s,k-1,mLen,dp)%mod)%mod;
            }
        }
        return dp[i][k]=(int)ans%mod;
    }
    
    private boolean isPrime(int num){
        if(num==2 || num==3 || num==5 || num==7)return true;
        return false;
    }
}