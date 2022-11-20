class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        // if last digit is prime then there is no possible solution return 0 then
        if(isPrime(s.charAt(s.length()-1))) return 0;
        dp=new long[k+1][s.length()];
        for(int i=0;i<=k;i++) Arrays.fill(dp[i],-1);
        return (int)bs(s,k,minLength,0);
}
    long[][] dp;

    //will check if the char is prime or not
    public boolean isPrime(char num){
        if(num=='2'||num=='3'||num=='5'||num=='7') return true;
        return false;
    }

    public long bs(String s,int k,int ml,int idx){
        // base cases. if first digit is not prime than return 
        if(k<0||idx>=s.length()||!isPrime(s.charAt(idx))) return 0;

        // if there is only one partition left return 1 because we have already checked that last digit not is prime
        if(k==1){
            return 1;
        }

        if(dp[k][idx]!=-1) return dp[k][idx];
        long ans=0;

        //will check for minLength and more if there is any substring which matches the case
        // s.length()-(k-1)*ml this is written because we want to give rest elements appropriate digits
        for(int i=idx+ml-1;i<s.length()-(k-1)*ml;i++){
            if(!isPrime(s.charAt(i))){
                ans=(ans+bs(s,k-1,ml,i+1))%1000000007;
            }
        }
        return dp[k][idx]=ans;
    }
}