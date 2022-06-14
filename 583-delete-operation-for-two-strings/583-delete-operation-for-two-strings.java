class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        int len=memo(word1,word2,word1.length()-1,word2.length()-1,dp);
        int totalLen=word1.length()+word2.length();
        
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