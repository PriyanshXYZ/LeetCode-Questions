class Solution {
    
    public int countVowelStrings(int n) {
        int[][] dp=new int[n+1][6];
        return memo(0,0,n,dp);
    }
    public int recursion(int idx,int vowel,int n){
        if(idx==n)return 1;
        if(vowel>=5)return 0;
        int inc=0,exc=0;
        
        inc=recursion(idx+1,vowel,n);//inc same element
        exc=recursion(idx,vowel+1,n);//exc
        
        return inc+exc;
    }
    public int memo(int idx,int vowel,int n,int[][] dp){
        if(idx==n)return dp[idx][vowel]=1;
        if(vowel>=5)return dp[idx][vowel]=0;
        if(dp[idx][vowel]!=0)return dp[idx][vowel];
        
        int inc=0,exc=0;
        inc=memo(idx+1,vowel,n,dp);
        
        exc=memo(idx,vowel+1,n,dp);
        return dp[idx][vowel]=inc+exc;
    }
}