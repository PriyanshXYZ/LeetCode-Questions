class Solution {
    public int distinctSubseqII(String s) {
        int[] dp=new int[s.length()+1];
        int mod=(int)(1e9+7);
        
        dp[0]=1;
        
        int[] lastOcc=new int[26];
        
        
        for(int i = 1;i < dp.length ;i++){
            dp[i] = (2 * dp[i-1])%mod;
            
            int ch = s.charAt(i-1)-'a';
            if(lastOcc[ch] > 0){
                dp[i] = (dp[i] - dp[lastOcc[ch]-1]+mod)%mod;
            }
            lastOcc[ch] = i;
        }
        dp[s.length()]--;//removing empty string at last
        
        return dp[s.length()]%mod;
    }
}