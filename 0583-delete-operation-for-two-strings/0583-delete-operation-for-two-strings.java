class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp=new int[n+1][m+1];
        // int len=memo(word1,word2,word1.length()-1,word2.length()-1,dp);
        int totalLen=n+m;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int ans = Math.max(dp[i][j-1], dp[i-1][j]);
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    ans = 1 + dp[i-1][j-1];
                }
                dp[i][j] = ans;
            }
        }
        
        int len = dp[n][m];
        return totalLen-2*len;
    }
    
    public int subarray(String s1,String s2,int idx1,int idx2){
        //base case
        if(idx1==-1 || idx2==-1)return 0;
        
        int len=0;
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            len=subarray(s1,s2,idx1-1,idx2-1);
            
            return 1+len;
        }
        
        int len1=subarray(s1,s2,idx1-1,idx2);
        int len2=subarray(s1,s2,idx1,idx2-1);
        
        len=Math.max(len1,len2);
        return len;
    }
    
    public int memo(String s1,String s2,int idx1,int idx2,int[][] dp){
        //base case
        if(idx1==-1 || idx2==-1)return dp[idx1+1][idx2+1]=0;
        
        if(dp[idx1+1][idx2+1]!=0)return dp[idx1+1][idx2+1];
        
        
        int len=0;
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            len=memo(s1,s2,idx1-1,idx2-1,dp);
            
            return dp[idx1+1][idx2+1]=1+len;
        }
        
        int len1=memo(s1,s2,idx1-1,idx2,dp);
        int len2=memo(s1,s2,idx1,idx2-1,dp);
        
        len=Math.max(len1,len2);
        return dp[idx1+1][idx2+1]=len;
    }
    
    
}