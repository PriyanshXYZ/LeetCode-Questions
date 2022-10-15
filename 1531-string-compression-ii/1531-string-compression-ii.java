class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n=s.length();
        int[][][][] dp=new int[s.length()][26][s.length()+1][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<26;j++){
                for(int m=0;m<=n;m++){
                    Arrays.fill(dp[i][j][m],Integer.MAX_VALUE);
                }
            }
        }
        return memo(0,0,0,k,s,dp);
    }
    
    int calcLen(int len){
        if(len==0)return 0;
        if(len==1)return 1;
        else if(len<10)return 2;
        else if(len<100)return 3;
        else{
            return 4;
        }
    }
    
    public int memo(int idx,int ch,int len,int k,String s,int[][][][] dp){
        
        if(idx==s.length())return calcLen(len);
        
        if(dp[idx][ch][len][k]!=Integer.MAX_VALUE)return dp[idx][ch][len][k];
        
        
        int curr=s.charAt(idx)-'a';
        int ans=Integer.MAX_VALUE;
        //include
        if(k>0){
            ans=memo(idx+1,ch,len,k-1,s,dp);
        }
        //exclude
        //prev value is same
        if(ch==curr){
            ans=Math.min(ans,memo(idx+1,ch,len+1,k,s,dp));
        }else{
            //prev value is not same
            ans=Math.min(ans,memo(idx+1,curr,1,k,s,dp)+calcLen(len));
        }
        
        return dp[idx][ch][len][k]=ans;
        
    }
}