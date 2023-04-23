class Solution {
    static final int MOD = (int)(1e9+7);
    Long[] dp;
    public int numberOfArrays(String s, int k) {
        dp = new Long[s.length()+1];
        return (int)(memo(0,s,k) % MOD);
    }
    public long memo(int idx, String s, int k){
        //base case
        if(idx == s.length())return 1;
        if(s.charAt(idx)=='0')return 0;
        
        if(dp[idx] != null)return dp[idx];
        
        long ans = 0;
        long num = 0;
        for(int i=idx;i<s.length();i++){
            num = num * 10 + s.charAt(i) - '0';
            if(num<=k){
                ans = ans % MOD  + memo(i + 1,s,k) % MOD;
            }else break;
        }
        return dp[idx] = ans % MOD;
    }
}