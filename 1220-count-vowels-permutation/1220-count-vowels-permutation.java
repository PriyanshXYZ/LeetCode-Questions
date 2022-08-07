class Solution {
    int mod=(int)(1e9+7);
    int a = 0, e = 1, i = 2, o = 3, u = 4 , s = 5;
    public int countVowelPermutation(int n) {
        long ans=0;
        int[][] dp=new int[n+1][6];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        ans=(ans+memo(0,n,s,dp))%mod;
        return (int)ans%mod;
    }
    
    
    public int memo(int idx,int n,int vow,int[][] dp){
        if(idx==n)return 1;
        
        if(dp[idx][vow]!=-1)return dp[idx][vow];
        long ans=0;
        if(vow==s){
            for(int j=0;j<5;j++){
                ans=(ans+memo(idx+1,n,j,dp))%mod;
            }
        }
        else if(vow==a){
            ans=(ans+memo(idx+1,n,e,dp))%mod;
        }else if(vow==e){
            ans=(ans+memo(idx+1,n,a,dp))%mod;
            ans=(ans+memo(idx+1,n,i,dp))%mod;
        }else if(vow==i){
            ans=(ans+memo(idx+1,n,a,dp))%mod;
            ans=(ans+memo(idx+1,n,e,dp))%mod;
            ans=(ans+memo(idx+1,n,o,dp))%mod;
            ans=(ans+memo(idx+1,n,u,dp))%mod;
        }else if(vow==o){
            ans=(ans+memo(idx+1,n,i,dp))%mod;
            ans=(ans+memo(idx+1,n,u,dp))%mod;
        }else{
            ans=(ans+memo(idx+1,n,a,dp))%mod;
        }
        
        return dp[idx][vow]=(int)ans%mod;
    }
}