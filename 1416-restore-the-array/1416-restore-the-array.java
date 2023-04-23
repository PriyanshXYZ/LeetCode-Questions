class Solution {
    static final int MOD = (int)(1e9+7);
    Long[] dp = new Long[(int)1e5+1];
    public int numberOfArrays(String s, int k) {
        return (int)(recursion(0,new StringBuilder(s),k) % MOD);
    }
    public long recursion(int idx, StringBuilder s, int k){
        //base case
        if(idx >= s.length())return 1;
        if(s.charAt(idx)=='0')return 0;
        
        if(dp[idx] != null)return dp[idx];
        
        long ans = 0;
        for(int i=idx+1;i<=s.length();i++){
            long num = Long.parseLong(s.substring(idx,i));
            if(num<=k){
                ans = ans % MOD  + recursion(i,s,k) % MOD;
            }else break;
        }
        return dp[idx] = ans % MOD;
    }
}