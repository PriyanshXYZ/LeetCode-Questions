class Solution {
    
    public int countVowelStrings(int n) {
        int[][] dp=new int[n+1][6];
        // return memo(0,0,n,dp);
        // return tabulation(n);
        return optimized(n);
    }
    //Tc O(n^2) Sc O(n)
    public int recursion(int idx,int vowel,int n){
        if(idx==n)return 1;
        if(vowel>=5)return 0;
        int inc=0,exc=0;
        
        inc=recursion(idx+1,vowel,n);//inc same element
        exc=recursion(idx,vowel+1,n);//exc
        
        return inc+exc;
    }
    //TC O(n) SC O(n) 
    public int memo(int idx,int vowel,int n,int[][] dp){
        if(idx==n)return dp[idx][vowel]=1;
        if(vowel>=5)return dp[idx][vowel]=0;
        if(dp[idx][vowel]!=0)return dp[idx][vowel];
        
        int inc=0,exc=0;
        inc=memo(idx+1,vowel,n,dp);
        
        exc=memo(idx,vowel+1,n,dp);
        return dp[idx][vowel]=inc+exc;
    }
    
    public int tabulation(int n){
        int[][] dp=new int[n+1][6];
        for(int idx=n;idx>=0;idx--){
            for(int vowel=5;vowel>=0;vowel--){
                if(idx==n){
                    dp[idx][vowel]=1;
                    continue;
                }
                
                int exc=0,inc=0;
                if(idx+1<=n)
                    inc=dp[idx+1][vowel];
                
                if(vowel+1<5)
                    exc=dp[idx][vowel+1];
                dp[idx][vowel]=inc+exc;
            }
        }
        return dp[0][0];
    }
    // TC O(n) SC O(1) 
    public int optimized(int n){
        int[] dp={1,1,1,1,1,0};
        for(int i=0;i<n;i++){
            for(int j=4;j>=0;j--){
                dp[j]+=dp[j+1];
            }
        }
        return dp[0];
    }
}